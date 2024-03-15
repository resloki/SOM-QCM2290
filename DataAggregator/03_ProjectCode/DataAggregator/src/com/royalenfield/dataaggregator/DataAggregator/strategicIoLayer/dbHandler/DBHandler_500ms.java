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

/**
 * DBHandler_500ms is responsible for handling the database operations related to
 * storing and managing data received at 500ms intervals.
 */
public class DBHandler_500ms extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DATA_AGGREGATOR_DATABASE_500ms";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "VEHICLE_DATA_500ms";
    private static final String COLUMN_TIMESTAMP = "TIMESTAMP";
    private static final String COLUMN_CAN_ID = "CAN_ID";
    private static final String COLUMN_SIGNAL_NAME = "SIGNAL_NAME";
    private static final String COLUMN_DATA = "DATA";
    private static final long DELETE_INTERVAL_MS = 15 * 60 * 1000;
    private static final String TAG = "StoreToDatabase";

    public DBHandler_500ms(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        scheduleDataDeletionTask(context);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_TIMESTAMP + " TEXT," +
                COLUMN_CAN_ID + " INTEGER," +
                COLUMN_SIGNAL_NAME + " TEXT," +
                COLUMN_DATA + " TEXT," +
                "PRIMARY KEY (" + COLUMN_CAN_ID + ", " + COLUMN_SIGNAL_NAME + ")" +
                ");";

        db.execSQL(createTableQuery);

        Log.d(TAG, "Table created successfully: " + TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void scheduleDataDeletionTask(Context context) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                deleteOldRows();

                scheduleDataDeletionTask(context);
            }
        }, DELETE_INTERVAL_MS);
    }

    /**
     * Deletes old rows from the database that are older than 15 minutes.
     */

    private void deleteOldRows() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.beginTransaction();

            long currentTime = System.currentTimeMillis();
            long fifteenMinutesInMillis = 15 * 60 * 1000;
            long fifteenMinutesAgo = currentTime - fifteenMinutesInMillis;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
            String fifteenMinutesAgoStr = dateFormat.format(new Date(fifteenMinutesAgo));

            int rowsDeleted = db.delete(TABLE_NAME, COLUMN_TIMESTAMP + " < ?", new String[]{fifteenMinutesAgoStr});
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

                cursor = db.query(TABLE_NAME, null,
                        COLUMN_CAN_ID + "=? AND " + COLUMN_SIGNAL_NAME + "=?",
                        new String[]{String.valueOf(canId), signalName},
                        null, null, null);

                if (cursor != null && cursor.moveToFirst()) {
                    ContentValues updateValues = new ContentValues();
                    updateValues.put(COLUMN_DATA, String.valueOf(data));
                    updateValues.put(COLUMN_TIMESTAMP, formattedTimestamp);

                    int rowsAffected = db.update(TABLE_NAME, updateValues,
                            COLUMN_CAN_ID + "=? AND " + COLUMN_SIGNAL_NAME + "=?",
                            new String[]{String.valueOf(canId), signalName});

                    if (rowsAffected > 0) {
                        Log.d(TAG, "Timestamp: " + formattedTimestamp + ", CAN ID: 0x" + Integer.toHexString(canId) + ", Signal Name: " + signalName + ", Data: " + String.valueOf(data));
                    } else {
                        Log.e(TAG, "Error updating data. CAN ID: " + Integer.toHexString(canId));
                    }
                } else {
                    ContentValues insertValues = new ContentValues();
                    insertValues.put(COLUMN_CAN_ID, canId);
                    insertValues.put(COLUMN_SIGNAL_NAME, signalName);
                    insertValues.put(COLUMN_DATA, String.valueOf(data));
                    insertValues.put(COLUMN_TIMESTAMP, formattedTimestamp);

                    long rowId = db.insert(TABLE_NAME, null, insertValues);

                    if (rowId != -1) {
                        Log.d(TAG, "Timestamp: " + formattedTimestamp + ", CAN ID: 0x" + Integer.toHexString(canId) + ", Signal Name: " + signalName + ", Data: " + String.valueOf(data));
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

}
