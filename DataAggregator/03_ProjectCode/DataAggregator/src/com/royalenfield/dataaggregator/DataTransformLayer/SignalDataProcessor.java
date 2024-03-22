package com.royalenfield.dataaggregator.DataTransformLayer;

import android.content.Context;
import android.util.Log;

import com.royalenfield.dataaggregator.DataPreserveLayer.Intervals;
import com.royalenfield.dataaggregator.strategicIoLayer.SignalPublisher;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_10ms;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_500ms;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_50ms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
