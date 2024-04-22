package com.royalenfield.dataaggregator;


import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.royalenfield.DataAggregator.VehicleDataInterface;
import com.royalenfield.dataaggregator.DataPreserveLayer.CanMapping;
import com.royalenfield.dataaggregator.FrameStructure.CanFrames;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DBHandler_10ms;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DBHandler_500ms;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DBHandler_50ms;
import com.royalenfield.dataaggregator.StrategicIoLayer.DatabaseHandler.DatabaseInterval;
import com.royalenfield.uartservice.VcanCommunicationCallback;
import com.royalenfield.uartservice.VcanCommunicationInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * DataAggregatorMain is the main service class responsible for aggregating and processing incoming CAN messages.
 * It initializes the CanMapping component to handle the mapping of CAN data.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */

public class DataAggregatorMain extends Service {
    private CanMapping canMapping;
    ExecutorService executorService;
    private final IBinder binder = new DataAggregatorMainBinder(this);
    private VcanCommunicationInterface vcanService;
    private static final String TAG = "DataAggregatorMain";
    private boolean isServiceConnected = false;
    private DBHandler_10ms dbHandler10ms;
    private DBHandler_50ms dbHandler50ms;
    private DBHandler_500ms dbHandler500ms;
    private List<String> registeredCanIds = new ArrayList<>();


    public DataAggregatorMain() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate called");
        establishConnection();
        canMapping = new CanMapping(this);
        executorService = Executors.newSingleThreadExecutor();
        Log.d(TAG, "CanMapping and executorService initialized");
        dbHandler10ms = new DBHandler_10ms(this);
        dbHandler50ms = new DBHandler_50ms(this);
        dbHandler500ms = new DBHandler_500ms(this);

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Log.d(TAG, "onStartCommand called");
            return Service.START_STICKY_COMPATIBILITY;
        } catch (Exception e) {
            Log.e(TAG, "Error initializing CustomUARTDriver: " + e.getMessage());
            stopSelf();
            return Service.START_NOT_STICKY;
        }
    }

    /**
     * @param ServiceConnection implementation for connecting to UARTService and DataAggregator.
     * Handles the communication between the current component and the bound service.
     */

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "Service connected called");
            vcanService = VcanCommunicationInterface.Stub.asInterface(service);
            Log.d(TAG, "Service connected");
            isServiceConnected = true;
            try {
                vcanService.vcanConnect(7);
                vcanService.registerReception(mCallback);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in service connection: " + e.getMessage());
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            try {
                vcanService.vcanDisconnect();
                isServiceConnected = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * @param VcanCommunicationCallback Stub is used for handling callbacks from UartService service.
     * Defines the behavior upon receiving data from CANId with associated Data and length.
     */
    private VcanCommunicationCallback.Stub mCallback = new VcanCommunicationCallback.Stub() {
        @Override
        public void onReceive(int CANId, byte MessageType, byte IDE, byte[] Data, int DataLen) throws RemoteException {
            processReceivedCanFrame(CANId, Data);
        }

    };

    /**
     * @param VehicleDataInterface Stub is used for fetching data from the database.
     * Allows other applications to request data associated with a specific CANId.
     */
    private final VehicleDataInterface.Stub dataFetcherBinder = new VehicleDataInterface.Stub() {
        @Override
        public String[] requestCanid(String canId) throws RemoteException {
            Log.d(TAG, "canId is:" + canId);
            DatabaseInterval databaseInterval = checkCanIdExist(canId);
            if (databaseInterval != null) {
                Log.d(TAG, "CanId " + canId + " exists in at least one database.");
                return retrieveData(canId, databaseInterval);
            } else {
                Log.d(TAG, "CanId " + canId + " does not exist in any database.");
            }
            return null;
        }
    };


    /**
     * Retrieves data from the database based on the CAN ID and specified database interval.
     *
     * @param canId            The CAN ID for which data is to be retrieved.
     * @param databaseInterval The interval of the database (e.g., DATABASE10ms, DATABASE50ms, DATABASE500ms).
     * @return An array of strings representing the retrieved data. Returns an empty array if no data is found or an error occurs.
     */
    private String[] retrieveData(String canId, DatabaseInterval databaseInterval) {
        SignalRecord[] signalRecord = null;
        try {
            switch (databaseInterval) {
                case DATABASE10ms:
                    signalRecord = dbHandler10ms.fetchFromDatabase10ms(canId);
                    break;
                case DATABASE50ms:
                    signalRecord = dbHandler50ms.fetchFromDatabase50ms(canId);
                    break;
                case DATABASE500ms:
                    signalRecord = dbHandler500ms.fetchFromDatabase500ms(canId);
                    break;
                default:
                    break;
            }

            if (signalRecord != null) {
                String[] fetchedData = new String[signalRecord.length];
                for (int i = 0; i < signalRecord.length; i++) {
                    fetchedData[i] = signalRecord[i].toString();
                }
                return fetchedData;
            } else {
                return new String[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public static class DataAggregatorMainBinder extends Binder {
        private final DataAggregatorMain service;
        private static final String TAG = "com/royalenfield/uartservice/DataAggregator";

        public DataAggregatorMainBinder(DataAggregatorMain service) {
            this.service = service;
            Log.d(TAG, "DataAggregatorMainBinder constructor called");
        }

        public DataAggregatorMain getService() {
            Log.d(TAG, "getService called");
            return service;
        }
    }

    /**
     * Checks if the given CAN ID exists in any of the database intervals (10ms, 50ms, or 500ms).
     *
     * @param canId The CAN ID to check for existence in the databases.
     * @return The database interval (e.g., DATABASE10ms, DATABASE50ms, DATABASE500ms) if the CAN ID exists in any of the databases; otherwise, returns null.
     */
    private DatabaseInterval checkCanIdExist(String canId) {
        if (dbHandler10ms.canIdInDatabase10ms(canId)) {
            return DatabaseInterval.DATABASE10ms;
        } else if (dbHandler50ms.canIdInDatabase50ms(canId)) {
            return DatabaseInterval.DATABASE50ms;
        } else if (dbHandler500ms.canIdInDatabase500ms(canId)) {
            return DatabaseInterval.DATABASE500ms;
        }
        return null;
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind called");
        if (intent != null) {
            String action = intent.getAction();
            if ("com.royalenfield.dataaggregator.BROADCAST_THROUGH_AIDL".equals(action)) {
                Log.d(TAG, "dataFetcherBinder called");
                return dataFetcherBinder;
            } else if ("com.royalenfield.dataaggregator.ACTION_OTHER_SERVICE".equals(action)) {
                return binder;
            }
        } else {
            Log.e(TAG, "Intent is null");
        }
        return null;
    }

    private void establishConnection() {
        try {
            Intent intent = new Intent("com.royalenfield.ACTION_UART_SERVICE");
            intent.setPackage("com.royalenfield.uartservice");
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            Log.d(TAG, "bindservice called");
        } catch (Exception e) {
            Log.e(TAG, "Error in binding: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Transmits a CAN frame to the Vehicle Data Analyzer (VDA) by processing the provided message.
     *
     * @param Msg The CAN frame message to be transmitted to the VDA.
     */
    public void transmitCanFrameToVDA(CanFrames Msg) {
        try {
            canMapping.processData(Msg);
            Log.d(TAG, "transmitCanFrameToVDA called");
        } catch (Exception e) {
            Log.e(TAG, "Error in transmitCanFrameToVDA: " + e.getMessage());
        }
    }

    /**
     * Processes a received CAN frame by converting it into a CanFrames object and transmitting it to the VDA.
     * This method is typically called upon receiving a CAN frame from the IO interface.
     *
     * @param canId The CAN ID of the received frame.
     * @param data  The data payload of the received frame.
     */
    public void processReceivedCanFrame(int canId, byte[] data) {
        CanFrames canFrame = new CanFrames();
        canFrame.CANId = canId;
        canFrame.Data = data;
        canFrame.DataLen = (byte) data.length;

        String logMessage = "Received CAN message - "
                + "CANId: " + canId
                + ", Data: " + Arrays.toString(data);
        Log.d("VDAData", "Received data " + logMessage);

        executorService.submit(() -> {
            try {
                transmitCanFrameToVDA(canFrame);
                Log.d(TAG, "CAN message sent to VDA successfully");
            } catch (Exception e) {
                Log.e(TAG, "Error sending CAN message to VDA: " + e.getMessage());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            vcanService.vcanDisconnect();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
