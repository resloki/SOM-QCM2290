package com.royalenfield.dataaggregator.DataPreserveLayer;

import android.content.Context;
import android.util.Log;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.royalenfield.dataaggregator.CanIDConfig.*;
import com.royalenfield.dataaggregator.DataTransformLayer.CanDataProcessor;
import com.royalenfield.dataaggregator.FrameStructure.CanFrames;

/**
 * CanMapping class manages the processing and mapping of incoming CAN messages.
 * It buffers incoming messages based on their intervals and delegates processing to appropriate handlers.
 * The class maintains three buffers for 10ms, 50ms, and 500ms intervals.
 * It utilizes a CanDataProcessor for handling the data and a CanHandlerRegistry for mapping CAN IDs to handlers.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */

public class CanMapping {
    Context context;
    CanIDManager canIdManager = new CanIDManager();
    private static final String TAG = "CanMapping";
    private CanDataProcessor canDataProcessor;
    private ExecutorService executorService;
    protected boolean flag10ms = false;
    protected boolean flag50ms = false;
    protected boolean flag500ms = false;
    Scheduler scheduler = new Scheduler(this);
    private CanHandlerRegistry handlerRegistry;
    protected CircularBuffer<CanFrames> buffer10ms;
    protected CircularBuffer<CanFrames> buffer50ms;
    protected CircularBuffer<CanFrames> buffer500ms;
    protected int bufferSize10ms=10;
    protected int bufferSize50ms=50;
    protected int bufferSize500ms=500;

    public CanMapping(Context context) {
        if (context == null) {
            Log.e(TAG, "context is null");
            return;
        }
        this.context = context;
        this.canDataProcessor = new CanDataProcessor(context);
        this.handlerRegistry = new CanHandlerRegistry(canDataProcessor);
        this.executorService = Executors.newSingleThreadExecutor();
        buffer10ms = new CircularBuffer<>(bufferSize10ms);
        buffer50ms = new CircularBuffer<>(bufferSize50ms);
        buffer500ms = new CircularBuffer<>(bufferSize500ms);
    }

    /**
     * Processes incoming CAN messages.
     * Determines the interval based on the CAN ID and delegates processing to the appropriate handler.
     *
     * @param receivedData The CAN frame received for processing.
     */
    public void processData(CanFrames receivedData) {
        try {
            int receivedCanId = receivedData.CANId;

            if (isCanIdInBuffer(canIdManager.CanID_10ms, receivedCanId)) {
                if (!flag10ms) {
                    flag10ms = true;
                    buffer10ms.add(receivedData);
                    Log.d(TAG, "Data added to buffer10ms");
                    scheduler.createTimer(Intervals.Milliseconds_10, 10);
                } else {
                    updateBuffer(buffer10ms, receivedData);
                    Log.d(TAG, "Update the buffer10ms");
                    flag10ms = false;
                }
            } else if (isCanIdInBuffer(canIdManager.CanID_50ms, receivedCanId)) {
                if (!flag50ms) {
                    flag50ms = true;
                    buffer50ms.add(receivedData);
                    Log.d(TAG, "Data added to buffer10ms");
                    scheduler.createTimer(Intervals.Milliseconds_50, 50);
                } else {
                    updateBuffer(buffer50ms, receivedData);
                    Log.d(TAG, "Update the buffer50ms");
                    flag50ms = false;
                }
            } else if (isCanIdInBuffer(canIdManager.CanID_500ms, receivedCanId)) {
                if (!flag500ms) {
                    flag500ms = true;
                    buffer500ms.add(receivedData);
                    Log.d(TAG, "Data added to buffer500ms");
                    scheduler.createTimer(Intervals.Milliseconds_500, 500);
                } else {
                    updateBuffer(buffer500ms, receivedData);
                    Log.d(TAG, "Update the buffer500ms");
                    flag500ms = false;
                }
            } else {
                Log.e(TAG, "Invalid CanId in processData");
                flag10ms = false;
                flag50ms = false;
                flag500ms = false;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error processing received data: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Updates the provided circular buffer with new CAN frame data, replacing any existing data with the same CAN ID.
     *
     * @param buffer The circular buffer to be updated.
     * @param receivedData The new CAN frame data to be added to the buffer.
     */
    private void updateBuffer(CircularBuffer<CanFrames> buffer, CanFrames receivedData) {
        Iterator<CanFrames> iterator = buffer.iterator();
        while (iterator.hasNext()) {
            CanFrames existingData = iterator.next();
            if (existingData.CANId == receivedData.CANId) {
                iterator.remove();
            }
        }
        buffer.add(receivedData);
    }

    /**
     * Checks if the given CAN ID is present in the provided array of CAN IDs.
     *
     * @param CanBuffer The array of CAN IDs to check.
     * @param receivedCanId The CAN ID to search for in the array.
     * @return true if the CAN ID is found in the array, false otherwise.
     */
    private boolean isCanIdInBuffer(byte[] CanBuffer, int receivedCanId) {
        for (byte canId : CanBuffer) {
            if ((canId & 0xFF) == (receivedCanId & 0xFF)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Executes processing of buffered CAN frames using registered handlers.
     *
     * @param buffer The circular buffer containing the buffered CAN frames to be processed.
     * @param interval The interval at which the buffered data was collected.
     */
    protected void executeBufferedData(CircularBuffer<CanFrames> buffer, Intervals interval) {
        if (context == null) {
            Log.e(TAG, "context is null");
            return;
        }
        for (int i = 0; i < buffer.size(); i++) {
            CanFrames receivedData = buffer.get(i);
            int receivedCanId = receivedData.CANId;
            CanHandler handler = handlerRegistry.getHandler(receivedCanId);
            Log.d("CanFramesHandler", "CanHandler");
            try {
                if (handler != null) {
                    executorService.submit(() -> handler.handleCanData(receivedData, interval));
                    Log.d("CanFramesHandler", "Send Data to Deserialize");
                } else {
                    Log.e("CanFramesHandler", "Invalid CanId");
                }
            } catch (Exception e) {
                Log.e(TAG, "Error in processBufferedData: " + e.getMessage());
                e.printStackTrace();
            }
        }
        buffer.clear();
    }
}
