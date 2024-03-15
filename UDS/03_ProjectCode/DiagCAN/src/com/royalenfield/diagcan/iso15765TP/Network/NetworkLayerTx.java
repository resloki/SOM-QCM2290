package com.royalenfield.diagcan.iso15765TP.Network;

import android.util.Log;

import com.royalenfield.diagcan.iso15765TP.DataLinkConnectorTP;
import com.royalenfield.diagcan.iso15765TP.I15765CanConfig;
import com.royalenfield.diagcan.iso15765TP.Transport.CANFrameType;
import com.royalenfield.diagcan.iso15765TP.Transport.CANSegmented;
import com.royalenfield.diagcan.iso15765TP.Transport.Transport;

import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class NetworkLayerTx extends I15765CanConfig {
    String TAG="NetworkLayerTx:";
    private static final ConcurrentMap<Long, CANSegmented> segmentedMap = new ConcurrentHashMap<>();
    private Transport transport;
    DataLinkConnectorTP connectDataLink;
    private static Timer timer;
    private static TimerTask task;
    private static Semaphore semaphore;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static boolean ExpectingFlowContolFlag = false;

    NetworkLayerTx(Transport transport, DataLinkConnectorTP connectDataLink) {
        this.transport = transport;
        this.connectDataLink = connectDataLink;
        semaphore = new Semaphore(1);
        timer = new Timer();
    }

    private static void setTimer(long newDelay) {
        cancelTimerTask();
        // Schedule a new TimerTask with the updated delay
        task = new TimerTask() {
            @Override
            public void run() {
                ExpectingFlowContolFlag = false;
                clearSegmentedMap();
                semaphore.release();
                long timestamp = System.currentTimeMillis();
                System.out.println(new java.util.Date(timestamp) + "    The operation timed out while awaiting the reception of Flow control frame from the receiving device.");
            }
        };

        // Schedule the updated task with the new delay
        timer.schedule(task, newDelay);
    }

    private static void cancelTimerTask() {
        // Check if the existing TimerTask is still running
        boolean isTaskRunning = task != null && !task.cancel();
        // If the task is running, cancel it
        if (isTaskRunning) {
            task.cancel();
        }
    }

    private static void clearSegmentedMap() {
        // Clear the segmentedMap
        segmentedMap.clear();
    }

    protected void processMultiFrameTxData(CANSegmented segments) {
        executorService.submit(() -> {
            try {
                semaphore.acquire();
                //System.out.println("Added to map: " + segments);
                long submissionTime = System.currentTimeMillis();
                segmentedMap.put(submissionTime, segments);
                byte[] firstFrame = segments.getFirstFrameData();
                connectDataLink.transmitDataToDL(physicalCanId,firstFrame);
                ExpectingFlowContolFlag = true;
                setTimer(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle or log the exception appropriately
            }
        });
    }

    public void handleFlowControlFrame(byte[] frame) {
        cancelTimerTask();
        if (!ExpectingFlowContolFlag) {
            return;
        }
        int flowStatus = frame[0];
        int blockSize = frame[1];
        int separationTime = frame[2];

        notifyFlowControlReceived(flowStatus, blockSize, separationTime);
    }

    public void notifyFlowControlReceived(int flowStatus, int blockSize, int separationTime) {
        Iterator<Map.Entry<Long, CANSegmented>> iterator = segmentedMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Long, CANSegmented> entry = iterator.next();

            CANSegmented segments = entry.getValue();

            if (segments != null && segments.getMessageType() == CANFrameType.MULTI_FRAME) {
                try {
                    sendNextBlock(blockSize, separationTime, segments);
                } catch (InterruptedException e) {
                    Log.e(TAG, " notifyFlowControlReceived Error:", e);
                }
                iterator.remove(); // Remove the entry from the map

            }
        }
    }

    private void sendNextBlock(int blockSize, int separationTime, CANSegmented segments) throws InterruptedException {
        byte[][] frames = segments.getMultiFrameData();
        segments.setCurrentFrameIndex(0); // Start from the first frame

        for (int i = CONSECUTIVE_FRAME_START_INDEX; i < frames.length; i++) {
            connectDataLink.transmitDataToDL(physicalCanId,frames[i]);
            segments.incrementCurrentFrameIndex();
            Thread.sleep(separationTime);
        }

        // Reset the current frame index after sending all frames
        segments.setCurrentFrameIndex(0);

        clearSegmentedMap();
        semaphore.release();
        ExpectingFlowContolFlag = false;
    }
}
