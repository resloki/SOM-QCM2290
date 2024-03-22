package com.royalenfield.diagcan.iso15765TP.Network;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;

import  com.royalenfield.diagcan.iso15765TP.DataLinkConnectorTP;
import  com.royalenfield.diagcan.iso15765TP.I15765CanConfig;
import  com.royalenfield.diagcan.iso15765TP.Transport.Transport;

import java.io.ByteArrayOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * The NetwrokLayerRx class represents the receiver side of the ISO 15765-2 Network layer.
 * It handles the reception and processing of ISO-TP multi-frame messages.
 * When a First Frame is received, it initializes the reception process by sending a Flow Control frame.
 * Consecutive Frames are collected until the complete message is received.
 * It also manages timers for timeout handling.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class NetwrokLayerRx extends I15765CanConfig{
    private static int expectedMultiFrameSize = 0;
    private static int receivedMultiFrameSize = 0;
    private static boolean expectingConsecutiveFrame = false;
    private static ByteArrayOutputStream multiFrameBuffer = new ByteArrayOutputStream();
    Transport Transport;
    DataLinkConnectorTP connectDataLink;
    private static Semaphore netwrokRxSemaphore;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static TimerTask task;
    private static Timer timer;

    NetwrokLayerRx(Transport Transport, DataLinkConnectorTP connectDataLink) {
        this.Transport = Transport;
        this.connectDataLink = connectDataLink;

        timer = new Timer();
        netwrokRxSemaphore = new Semaphore(1);
    }

    public void rxProcessRxFirstFrame(byte[] payload) throws InterruptedException {
        netwrokRxSemaphore.acquire();

        // Extract the data length from the first two bytes
        int dataLength = ((payload[0] & 0x0F) << 8) | (payload[1] & 0xFF);

        if (isValidDataLength(dataLength)) {
            initializeMultiFrame(dataLength, payload);
            sendFlowControlFrame();
        }
    }

    private boolean isValidDataLength(int dataLength) {
        return dataLength > 7 && dataLength <= CAN_TP_MAX_PAYLOAD_SIZE;
    }

    private void initializeMultiFrame(int dataLength, byte[] payload) {
        expectedMultiFrameSize = dataLength;
        receivedMultiFrameSize = payload.length - 2;
        multiFrameBuffer.reset();
        multiFrameBuffer.write(payload, 2, payload.length - 2);
        expectingConsecutiveFrame = true;
    }


    void processRxConsecutiveFrame(byte[] payload) {

        if (!expectingConsecutiveFrame) {
            return;
        }
        cancelTimerTask();
        // Add to the running total of received multi-frame size
        receivedMultiFrameSize += payload.length - 1;

        // Continue collecting the CF data
        multiFrameBuffer.write(payload, 1, payload.length - 1);

        // Check if the message is complete
        if (isRxMessageComplete()) {
            cancelTimerTask();
            byte[] completeMessage = multiFrameBuffer.toByteArray();
            CompletableFuture.runAsync(() -> {
                        try {
                            Transport.transportRx.processData(completeMessage, completeMessage.length);
                        } catch (Exception e) {
                            // Handle exceptions if needed
                        }
                    });
            resetRxState("ConsecutiveFrames completely Recieved successfully From Rx Device");
             return;
        }
        setnewTimer(5000);
    }


    private static void resetRxState(String Discription) {
        expectingConsecutiveFrame = false;
        expectedMultiFrameSize = 0;
        receivedMultiFrameSize = 0;
        multiFrameBuffer.reset();
        netwrokRxSemaphore.release();
        System.out.println(Discription);
    }


    void sendFlowControlFrame() throws InterruptedException {

        byte[] fcFrame = new byte[8];
        fcFrame[0] = 0x30; // Flow Control frame type + FlowStatus = CTS (Clear To Send)
        fcFrame[1] = 0x00; // Block Size (BS) = 0, meaning no specific block size
        fcFrame[2] = STMin_RX; // STMin Rx
        fcFrame[3] = 0x00;
        fcFrame[4] = 0x00;
        fcFrame[5] = 0x00;
        fcFrame[6] = 0x00;
        fcFrame[7] = 0x00;
        connectDataLink.transmitDataToDL(physicalCanId,fcFrame);
        setnewTimer(1500);
    }

    private static void setnewTimer(long newDelay) {
        try {
            cancelTimerTask();
            // Schedule a new TimerTask with the updated delay
            task = new TimerTask() {
                @Override
                public void run() {
                    resetRxState("The operation timed out while awaiting the reception of consecutive frames from the receiving device");
                }
            };
            // Schedule the updated task with the new delay
            timer.schedule(task, newDelay);
        } catch (Exception e) {
            Log.e(TAG, "timer.schedule Error:", e);
        }
    }

    private static boolean cancelTimerTask() {
        // Check if the existing TimerTask is still running
        boolean isTaskRunning = task != null && !task.cancel();

        // If the task is running, cancel it
        if (isTaskRunning) {
            task.cancel();
        }

        // Return whether the task was running or not
        return isTaskRunning;
    }


    boolean isRxMessageComplete() {
        return receivedMultiFrameSize >= expectedMultiFrameSize;
    }

}
