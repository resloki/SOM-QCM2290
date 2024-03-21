package com.royalenfield.dataaggregator.strategicIoLayer.dbHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.util.Log;

import com.royalenfield.dataaggregator.SignalRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * DBHandler_500ms is responsible for handling the database operations related to
 * storing and managing data received at 500ms intervals.
 */
public class DBHandler_500ms extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final long DELETE_INTERVAL_MS = 15 * 60 * 1000;
    private static final String TAG = "StoreToDatabase";

    private String tableName;
    private String timestampColumn;
    private String canIdColumn;
    private String signalNameColumn;
    private String dataColumn;
    private SignalRecord signalRecord;

    public DBHandler_500ms(Context context) {
        super(context, loadDatabaseName(context), null, DATABASE_VERSION);
        Properties properties = DatabaseConfigLoader.loadDatabaseConfig(context);
        this.tableName = properties.getProperty("dbhandler_500ms.table_name");
        this.timestampColumn = properties.getProperty("dbhandler_500ms.timestamp_column");
        this.canIdColumn = properties.getProperty("dbhandler_500ms.can_id_column");
        this.signalNameColumn = properties.getProperty("dbhandler_500ms.signal_name_column");
        this.dataColumn = properties.getProperty("dbhandler_500ms.data_column");
        scheduleDataDeletionTask(context);
    }

    private static String loadDatabaseName(Context context) {
        Properties properties = DatabaseConfigLoader.loadDatabaseConfig(context);
        return properties.getProperty("dbhandler_500ms.database_name");
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

            int rowsDeleted = db.delete(tableName, timestampColumn + " < ?", new String[]{fifteenMinutesAgoStr});
            Log.d("DeleteOldRows", rowsDeleted + " rows deleted.");

            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }
    public boolean canIdInDatabase500ms(String canId) {
        int decimalCanId = Integer.parseInt(String.valueOf(canId), 16);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        boolean canIdExists = false;

        try {
            cursor = db.rawQuery("SELECT * FROM " + tableName +
                    " WHERE " + canIdColumn + " = ?", new String[]{String.valueOf(decimalCanId)});
            if (cursor != null && cursor.moveToFirst()) {
                // If the cursor has rows, it means the canId exists in the database
                canIdExists = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return canIdExists;
    }

    public SignalRecord[] fetchFromDatabase500ms(String canId) {
        int decimalCanId = Integer.parseInt(canId, 16);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        SignalRecord[] signalRecords = null;

        try {
            cursor = db.rawQuery("SELECT * FROM " + tableName +
                    " WHERE " + canIdColumn + " = ?", new String[]{String.valueOf(decimalCanId)});

            int numRows = cursor.getCount();
            if (numRows > 0) {
                signalRecords = new SignalRecord[numRows];
                int index = 0;
                while (cursor.moveToNext()) {
                    int timestampColumnIndex = cursor.getColumnIndex(timestampColumn);
                    int signalNameColumnIndex = cursor.getColumnIndex(signalNameColumn);
                    int dataColumnIndex = cursor.getColumnIndex(dataColumn);

                    SignalRecord signalRecord = new SignalRecord();
                    signalRecord.setTimestamp(cursor.getString(timestampColumnIndex));
                    signalRecord.setCanId(canId);
                    signalRecord.setSignalName(cursor.getString(signalNameColumnIndex));
                    signalRecord.setData(cursor.getString(dataColumnIndex));

                    signalRecords[index] = signalRecord;
                    index++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return signalRecords;
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
                    updateValues.put(dataColumn, String.valueOf(data));
                    updateValues.put(timestampColumn, formattedTimestamp);

                    int rowsAffected = db.update(tableName, updateValues,
                            canIdColumn + "=? AND " + signalNameColumn + "=?",
                            new String[]{String.valueOf(canId), signalName});

                    if (rowsAffected > 0) {
                        Log.d(TAG, "Timestamp: " + formattedTimestamp + ", CAN ID: 0x" + Integer.toHexString(canId) + ", Signal Name: " + signalName + ", Data: 0x" + String.valueOf(data));
                    } else {
                        Log.e(TAG, "Error updating data. CAN ID: " + Integer.toHexString(canId));
                    }
                } else {
                    ContentValues insertValues = new ContentValues();
                    insertValues.put(timestampColumn, formattedTimestamp);
                    insertValues.put(canIdColumn, canId);
                    insertValues.put(signalNameColumn, signalName);
                    insertValues.put(dataColumn, String.valueOf(data));


                    long rowId = db.insert(tableName, null, insertValues);

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
