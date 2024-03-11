package com.royalenfield.dataaggregator.DataAggregator;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.royalenfield.dataaggregator.DataAggregator.DataPreserveLayer.CanMapping;
import com.royalenfield.dataaggregator.DataAggregator.FrameStructure.CanFrames;
import com.royalenfield.uartservice.VcanCommunicationCallback;
import com.royalenfield.uartservice.VcanCommunicationInterface;

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

    public DataAggregatorMain() {
    }

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

    private VcanCommunicationCallback.Stub mCallback = new VcanCommunicationCallback.Stub() {
        @Override
        public void onReceive(int CANId, byte[] Data, byte length) throws RemoteException {
            processReceivedCanFrame(CANId, Data);
        }

    };


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

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate called");
        Log.d(TAG, "DataAggregatorMain constructor called");
        canMapping = new CanMapping(this);
        executorService = Executors.newSingleThreadExecutor();
        Log.d(TAG, "CanMapping and executorService initialized");
        establishConnection();

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

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind called");
        return binder;
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
        Log.d(TAG, "sendCANMsgtoVDA called");

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
