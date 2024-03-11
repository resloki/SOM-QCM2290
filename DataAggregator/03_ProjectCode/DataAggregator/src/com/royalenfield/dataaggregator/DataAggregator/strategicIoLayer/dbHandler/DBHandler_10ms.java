package com.royalenfield.dataaggregator.DataAggregator.strategicIoLayer.dbHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * DBHandler_10ms is responsible for handling the database operations related to
 * storing and managing data received at 10ms intervals.
 */
public class DBHandler_10ms extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final long DELETE_INTERVAL_MS = 15 * 60 * 1000;
    private static final String TAG = "StoreToDatabase";

    private String tableName;
    private String timestampColumn;
    private String canIdColumn;
    private String signalNameColumn;
    private String dataColumn;

    public DBHandler_10ms(Context context) {
        super(context, loadDatabaseName(context), null, DATABASE_VERSION);
        Properties properties = DatabaseConfigLoader.loadDatabaseConfig(context);
        this.tableName = properties.getProperty("dbhandler_10ms.table_name");
        this.timestampColumn = properties.getProperty("dbhandler_10ms.timestamp_column");
        this.canIdColumn = properties.getProperty("dbhandler_10ms.can_id_column");
        this.signalNameColumn = properties.getProperty("dbhandler_10ms.signal_name_column");
        this.dataColumn = properties.getProperty("dbhandler_10ms.data_column");
        scheduleDataDeletionTask(context);
    }

    private static String loadDatabaseName(Context context) {
        Properties properties = DatabaseConfigLoader.loadDatabaseConfig(context);
        return properties.getProperty("dbhandler_10ms.database_name");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + tableName + " (" +
                timestampColumn + " TEXT," +
                canIdColumn + " INTEGER," +
                signalNameColumn + " TEXT," +
                dataColumn + " TEXT," +
                "PRIMARY KEY (" + canIdColumn + ", " + signalNameColumn + ")" +
                ");";

        db.execSQL(createTableQuery);

        Log.d(TAG, "Table created successfully: " + tableName);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Deletes old rows from the database that are older than 15 minutes.
     */
    private void scheduleDataDeletionTask(Context context) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                deleteOldRows();

                handler.postDelayed(this, DELETE_INTERVAL_MS);
            }
        }, DELETE_INTERVAL_MS);
    }

    private void deleteOldRows() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.beginTransaction();

            long currentTime = System.currentTimeMillis();
            long fifteenMinutesInMillis = 15 * 60 * 1000;
            long fifteenMinutesAgo = currentTime - fifteenMinutesInMillis;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
            String fifteenMinutesAgoStr = dateFormat.format(new Date(fifteenMinutesAgo));

            int rowsDeleted = db.delete(tableName, timestampColumn + " < ?", new String[]{fifteenMinutesAgoStr});
            Log.d("DeleteOldRows", rowsDeleted + " rows deleted.");

            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }


    public void saveDataToDatabase(int canId, Map<String, Object> signalDataMap) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;

        try {
            db.beginTransaction();

            for (Map.Entry<String, Object> entry : signalDataMap.entrySet()) {
                String signalName = entry.getKey();
                Object data = entry.getValue();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
                String formattedTimestamp = dateFormat.format(new Date());

                cursor = db.query(tableName, null,
                        canIdColumn + "=? AND " + signalNameColumn + "=?",
                        new String[]{String.valueOf(canId), signalName},
                        null, null, null);

                if (cursor != null && cursor.moveToFirst()) {
                    ContentValues updateValues = new ContentValues();
                    updateValues.put(dataColumn, convertValue(data));
                    updateValues.put(timestampColumn, formattedTimestamp);

                    int rowsAffected = db.update(tableName, updateValues,
                            canIdColumn + "=? AND " + signalNameColumn + "=?",
                            new String[]{String.valueOf(canId), signalName});

                    if (rowsAffected > 0) {
                        Log.d(TAG, "Timestamp: " + formattedTimestamp + ", CAN ID: 0x" + Integer.toHexString(canId) + ", Signal Name: " + signalName + ", Data: 0x" + Long.toHexString(convertValue(data)));
                    } else {
                        Log.e(TAG, "Error updating data. CAN ID: " + Integer.toHexString(canId));
                    }
                } else {
                    ContentValues insertValues = new ContentValues();
                    insertValues.put(timestampColumn, formattedTimestamp);
                    insertValues.put(canIdColumn, canId);
                    insertValues.put(signalNameColumn, signalName);
                    insertValues.put(dataColumn, convertValue(data));

                    long rowId = db.insert(tableName, null, insertValues);

                    if (rowId != -1) {
                        Log.d(TAG, "Timestamp: " + formattedTimestamp + ", CAN ID: 0x" + Integer.toHexString(canId) + ", Signal Name: " + signalName + ", Data: " + Long.toHexString(convertValue(data)));
                    } else {
                        Log.e(TAG, "Error inserting data");
                    }
                }
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.endTransaction();
        }
    }

    private long convertValue(Object value) {
        if (value instanceof Long) {
            return (Long) value;
        } else if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Short) {
            return (Short) value;
        } else if (value instanceof Byte) {
            return (Byte) value;
        } else {
            throw new IllegalArgumentException("Unsupported data type: " + value.getClass());
        }
    }

}
