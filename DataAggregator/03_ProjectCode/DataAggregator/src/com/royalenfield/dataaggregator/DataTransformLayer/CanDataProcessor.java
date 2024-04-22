package com.royalenfield.dataaggregator.DataTransformLayer;

import android.content.Context;

import com.royalenfield.dataaggregator.DataPreserveLayer.Intervals;
import com.royalenfield.dataaggregator.FrameStructure.CanFrames;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

/**
 * CanDataProcessor is responsible for handling the transformation of CAN messages into specific data structures.
 * It uses SignalConverter to deserialize CAN message data and processes it accordingly.
 * This class utilizes SignalDataProcessor to process the deserialized data and submit it to the database.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class CanDataProcessor {
    private Context context;
    private static final int THREAD_POOL_SIZE = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private SignalDataProcessor signalDataProcessor;

    public CanDataProcessor(Context context) {
        this.context = context;
        this.signalDataProcessor = new SignalDataProcessor(context);
    }

    /**
     * Handles incoming CAN messages.
     * Deserializes the CAN message data using SignalConverter and processes it using SignalDataProcessor.
     * @param receivedData The CAN frame received for processing.
     * @param interval The interval at which the CAN message was received.
     * @param messageType The type of message to deserialize the data into.
     * @param deserializer The function to deserialize the CAN message data.
     */
    public void handleCanMessage(CanFrames receivedData, Intervals interval, Object messageType, BiConsumer<Object, byte[]> deserializer) {
        try {
            deserializer.accept(messageType, receivedData.Data);

            Class<?> messageClass = messageType.getClass();
            Field[] fields = messageClass.getDeclaredFields();

            Map<String, Object> signalDataMap = new HashMap<>();

            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(messageType);
                    String signalName = field.getName();
                    signalDataMap.put(signalName, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            executorService.submit(() ->
                    signalDataProcessor.processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
