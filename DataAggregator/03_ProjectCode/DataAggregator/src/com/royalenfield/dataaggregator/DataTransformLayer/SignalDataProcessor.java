package com.royalenfield.dataaggregator.DataTransformLayer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.royalenfield.dataaggregator.DataPreserveLayer.Intervals;
import com.royalenfield.dataaggregator.SignalRecord;
import com.royalenfield.dataaggregator.StrategicIoLayer.DataTransmitter.SignalPublisher;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DBHandler_10ms;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DBHandler_500ms;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DBHandler_50ms;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DatabaseInterval;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * SignalDataProcessor processes and submits signal data to the database based on the provided CAN ID, signal data map,
 * and interval. It handles formatting timestamps, logging, and broadcasting signals. The class utilizes specific
 * database handlers for different intervals to save data accordingly.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class SignalDataProcessor {

    private static final String TAG = "SignalDataProcessor";
    private final Context context;
    private final DBHandler_10ms databaseHandler_10ms;
    private final DBHandler_50ms databaseHandler_50ms;
    private final DBHandler_500ms databaseHandler_500ms;

    public SignalDataProcessor(Context context) {
        this.context = context;
        databaseHandler_10ms = new DBHandler_10ms(context);
        databaseHandler_50ms = new DBHandler_50ms(context);
        databaseHandler_500ms = new DBHandler_500ms(context);
    }

    public void processAndSubmitDataToDB(int canId, Map<String, Object> signalDataMap, Intervals interval) {
        try {
            if (context == null) {
                Log.e(TAG, "Context is null");
                return;
            }

            for (Map.Entry<String, Object> entry : signalDataMap.entrySet()) {
                String signalName = entry.getKey();
                Object data = entry.getValue();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
                String formattedTimestamp = dateFormat.format(new Date());

                Log.d("DatabaseLog", " Timestamp: " + formattedTimestamp + "  CAN ID: 0x" + Integer.toHexString(canId) + "  Signal Name: " + signalName + "  Value: " + String.valueOf(data));

                SignalPublisher signalPublisher = new SignalPublisher(context);
                signalPublisher.SignalBroadcast(canId, signalName, data, formattedTimestamp);
            }

            switch (interval) {
                case Milliseconds_10: {
                    databaseHandler_10ms.saveDataToDatabase(canId, signalDataMap);
                    break;
                }
                case Milliseconds_50: {
                    databaseHandler_50ms.saveDataToDatabase(canId, signalDataMap);
                    break;
                }
                case Milliseconds_500: {
                    databaseHandler_500ms.saveDataToDatabase(canId, signalDataMap);
                    break;
                }
                default:
            }


            Properties properties = new Properties();
            try {
                InputStream inputStream = context.getAssets().open("broadcastData_config.properties");
                properties.load(inputStream);


                String[] canIds = properties.getProperty("canIds").split(",\\s*");
                boolean canIdExists = false;
                for (String CANId : canIds) {
                    DatabaseInterval databaseInterval = isCanIdExist(CANId);
                    if (databaseInterval != null) {
                        Log.d(TAG, "CanId " + CANId + " exists in at least one database.");
                        SignalRecord[] data = retrieveFromDatabase(CANId, databaseInterval);
                        broadcastData(data);
                    } else {
                        Log.d(TAG, "CanId " + CANId + " does not exist in any database.");
                    }
                }

                if (!canIdExists) {
                    Log.d(TAG, "CanId " + canIds + " does not exist in the properties file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SignalRecord[] retrieveFromDatabase(String canId, DatabaseInterval databaseInterval) {
        SignalRecord[] signalRecords = null;
        try {
            switch (databaseInterval) {
                case DATABASE10ms:
                    signalRecords = databaseHandler_10ms.fetchFromDatabase10ms(canId);
                    break;
                case DATABASE50ms:
                    signalRecords = databaseHandler_50ms.fetchFromDatabase50ms(canId);
                    break;
                case DATABASE500ms:
                    signalRecords = databaseHandler_500ms.fetchFromDatabase500ms(canId);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error retrieving data from database: " + e.getMessage());
            e.printStackTrace();
        }
        return signalRecords;
    }


    private DatabaseInterval isCanIdExist(String canId) {
        if (databaseHandler_10ms.canIdInDatabase10ms(canId)) {
            return DatabaseInterval.DATABASE10ms;
        } else if (databaseHandler_50ms.canIdInDatabase50ms(canId)) {
            return DatabaseInterval.DATABASE50ms;
        } else if (databaseHandler_500ms.canIdInDatabase500ms(canId)) {
            return DatabaseInterval.DATABASE500ms;
        }
        return null;
    }

    private void broadcastData(SignalRecord[] signalRecords) {
        String[] data = new String[signalRecords.length];
        for (int i = 0; i < signalRecords.length; i++) {
            data[i] = signalRecords[i].toString();
        }

        Intent intent = new Intent("com.re.BROADCAST_PARTICULAR_CANID");
        intent.putExtra("data", data);
        context.sendBroadcast(intent);
        Log.d(TAG, "Broadcasted data for CAN ID: " + signalRecords[0].getCanId()); // Assuming the first record's CAN ID is used for logging
    }


}
