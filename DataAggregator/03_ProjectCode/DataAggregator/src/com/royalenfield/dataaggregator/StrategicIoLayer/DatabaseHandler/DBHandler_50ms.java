package com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler;

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
 * DBHandler_50ms is responsible for handling the database operations related to
 * storing and managing data received at 50ms intervals.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class DBHandler_50ms extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final long DELETE_INTERVAL_MS = 15 * 60 * 1000;
    private static final String TAG = "StoreToDatabase";

    private String tableName;
    private String timestampColumn;
    private String canIdColumn;
    private String signalNameColumn;
    private String dataColumn;

    public DBHandler_50ms(Context context) {
        super(context, loadDatabaseName(context), null, DATABASE_VERSION);
        Properties properties = DatabaseConfigLoader.loadDatabaseConfig(context);
        this.tableName = properties.getProperty("dbhandler_50ms.table_name");
        this.timestampColumn = properties.getProperty("dbhandler_50ms.timestamp_column");
        this.canIdColumn = properties.getProperty("dbhandler_50ms.can_id_column");
        this.signalNameColumn = properties.getProperty("dbhandler_50ms.signal_name_column");
        this.dataColumn = properties.getProperty("dbhandler_50ms.data_column");
        scheduleDataDeletionTask();
    }

    private static String loadDatabaseName(Context context) {
        Properties properties = DatabaseConfigLoader.loadDatabaseConfig(context);
        return properties.getProperty("dbhandler_50ms.database_name");
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
    private void scheduleDataDeletionTask() {
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

    /**
     * Checks if a given CAN ID exists in the database table associated with 50ms intervals.
     *
     * @param canId The CAN ID to check for existence in the database.
     * @return true if the CAN ID exists in the database, false otherwise.
     */
    public boolean canIdInDatabase50ms(String canId) {
        int decimalCanId = 0;
        try {
            decimalCanId = Integer.parseInt(canId.replace("0x", ""), 16);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        boolean canIdExists = false;

        try {
            cursor = db.rawQuery("SELECT * FROM " + tableName +
                    " WHERE " + canIdColumn + " = ?", new String[]{String.valueOf(decimalCanId)});
            if (cursor != null && cursor.moveToFirst()) {
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

    /**
     * Fetches signal records associated with the given CAN ID from the database table associated with 50ms intervals.
     *
     * @param canId The CAN ID for which signal records are to be fetched.
     * @return An array of SignalRecord objects containing the fetched signal records, or null if no records are found.
     */
    public SignalRecord[] fetchFromDatabase50ms(String canId) {
        int decimalCanId = 0;
        try {
            decimalCanId = Integer.parseInt(canId.replace("0x", ""), 16);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
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

    /**
     * Saves signal data to the database table, updating existing records if the CAN ID and signal name already exist,
     * or inserting new records otherwise.
     *
     * @param canId          The CAN ID associated with the signal data.
     * @param signalDataMap  A map containing signal names as keys and corresponding data values to be saved.
     */
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
