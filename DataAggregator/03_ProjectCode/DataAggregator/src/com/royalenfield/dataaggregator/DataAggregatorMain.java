package com.royalenfield.dataaggregator;


import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.royalenfield.dataaggregator.DataPreserveLayer.CanMapping;
import com.royalenfield.dataaggregator.FrameStructure.CanFrames;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_10ms;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_500ms;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_50ms;
import com.royalenfield.uartservice.VcanCommunicationCallback;
import com.royalenfield.uartservice.VcanCommunicationInterface;
import com.royalenfield.uartservice.VehicleDataInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * DataAggregatorMain is the main service class responsible for aggregating and processing incoming CAN messages.
 * It initializes the CanMapping component to handle the mapping of CAN data.
 */


public class DataAggregatorMain extends Service {
    CanMapping canMapping;
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
        Log.d(TAG, "DataAggregatorMain constructor called");
        establishConnection();
        canMapping = new CanMapping(this);
        executorService = Executors.newSingleThreadExecutor();
        Log.d(TAG, "CanMapping and executorService initialized");
         dbHandler10ms=new DBHandler_10ms(this);
         dbHandler50ms=new DBHandler_50ms(this);
         dbHandler500ms=new DBHandler_500ms(this);
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
     * ServiceConnection implementation for connecting to UARTService and DataAggregator.
     * Handles the communication between the current component and the bound service.
     */

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            vcanService = VcanCommunicationInterface.Stub.asInterface(service);
            Log.d(TAG, "Remote config Service Connected!!");
            isServiceConnected = true;

            try {
                vcanService.registerReception(mCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "Service connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceConnected = false;
        }
    };

    /**
     * Stub implementation of VcanCommunicationCallback for handling callbacks from UartService service.
     * Defines the behavior upon receiving data from CANId with associated Data and length.
     */
    private VcanCommunicationCallback.Stub mCallback = new VcanCommunicationCallback.Stub() {
        @Override
        public void onReceive(int CANId, byte[] Data, byte length) throws RemoteException {
            processReceivedCanFrame(CANId, Data);
        }

    };

    /**
     * Stub implementation of VehicleDataInterface used for fetching data from the database.
     * Allows other applications to request data associated with a specific CANId.
     */
    private final VehicleDataInterface.Stub dataFetcherBinder = new VehicleDataInterface.Stub() {
        @Override
        public String[] requestCanid( String canId) throws RemoteException {
            Log.d(TAG,"canId is:"+ canId);
            DatabaseInterval databaseInterval = checkCanIdExist(canId);
            if (databaseInterval!=null) {
                Log.d(TAG, "CanId " + canId + " exists in at least one database.");
                return retrieveData(canId, databaseInterval);
            } else {
                Log.d(TAG, "CanId " + canId + " does not exist in any database.");
            }
            return null;
        }
    };


    private String[] retrieveData(String canId, DatabaseInterval databaseInterval) {
        SignalRecord[] signalRecord =null;
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
        private static final String TAG = "DataAggregator";

        public DataAggregatorMainBinder(DataAggregatorMain service) {
            this.service = service;
            Log.d(TAG, "DataAggregatorMainBinder constructor called");
        }

        public DataAggregatorMain getService() {
            Log.d(TAG, "getService called");
            return service;
        }
    }

    private DatabaseInterval checkCanIdExist(String canId) {
        if (dbHandler10ms.canIdInDatabase10ms(canId)) {
            return DatabaseInterval.DATABASE10ms;
        }else if (dbHandler50ms.canIdInDatabase50ms(canId)) {
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
                Log.d(TAG,"dataFetcherBinder called");
                return dataFetcherBinder;
            } else if ("com.royalenfield.dataaggregator.ACTION_OTHER_SERVICE".equals(action)) {
                return binder;
            }
        }else{
            Log.e(TAG,"Intent is null");
        }
        return null;
    }

    private void establishConnection() {
        try {
            Intent intent = new Intent("RoyalEnfieldUartService");
            intent.setPackage("com.royalenfield.uartservice");
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            Log.d(TAG, "bindservice called");
        } catch (Exception e) {
            Log.e(TAG, "Error in binding: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void transmitCanFrameToVDA(CanFrames Msg) {
        canMapping.processData(Msg);
        Log.d(TAG, "sendCANMsgToVDA called");

    }

    public void processReceivedCanFrame(int canId, byte[] data) {
        CanFrames canFrame = new CanFrames();
        canFrame.CANId = canId;
        canFrame.Data = data;
        canFrame.DataLen = (byte) data.length;
        Log.d(TAG, "ProcessDataReceivedFromIOInterface called");

        executorService.submit(() -> {
            try {
                transmitCanFrameToVDA(canFrame);
                Log.d(TAG, "CAN message sent to VDA successfully");
            } catch (Exception e) {
                Log.e(TAG, "Error sending CAN message to VDA: " + e.getMessage());
            }
        });
    }
}
