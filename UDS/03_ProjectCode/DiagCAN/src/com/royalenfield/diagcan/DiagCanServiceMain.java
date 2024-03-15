package com.royalenfield.diagcan;

import android.app.Service;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;

import com.royalenfield.diagcan.iso14229UDS.ApplicationService;
import com.royalenfield.diagcan.iso14229UDS.BootloaderService;
import com.royalenfield.diagcan.iso15765TP.DataLinkConnectorTP;
import com.royalenfield.diagcan.iso15765TP.RegisterCanTpCallbackDL;
import com.royalenfield.diagcan.iso15765TP.TpInterfaceManager;
import com.royalenfield.uartservice.VcanCommunicationCallback;
import com.royalenfield.uartservice.VcanCommunicationInterface;


import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiagCanServiceMain extends Service {

    private static final String TAG = "DiagCanServiceMain";

    private BootloaderService bootloaderService;
    private ApplicationService applicationService;
    private VcanCommunicationInterface vcanService;
    private boolean vcanServiceConnected = false;
    private RegisterCanTpCallbackDL canTpNetworkSender;
    private boolean serviceActiveState = false;
    private UdsCallbackEventManager callbackMgr;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    TpInterfaceManager canTpMgr;

    @Override
    public void onCreate() {
        super.onCreate();
        bindToVcanService();
        initializeComponents();
        callbackMgr = UdsCallbackEventManager.getInstance();

    }

    private void bindToVcanService() {
        try {
            Intent intent = new Intent("RoyalEnfieldUartService");
            intent.setPackage("com.royalenfield.uartservice");
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        } catch (Exception e) {
            Log.e(TAG, "Error in binding: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            vcanService = VcanCommunicationInterface.Stub.asInterface(iBinder);
            vcanServiceConnected = true;
            try {
                vcanService.registerReception(mCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "Service connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            vcanService = null;
            vcanServiceConnected = false;
            Log.d(TAG, "Service disconnected");
        }
    };

    private final VcanCommunicationCallback.Stub mCallback = new VcanCommunicationCallback.Stub() {

        @Override
        public void onReceive(int CANId, byte MessageType, byte IDE, byte[] Data, int DataLen) throws RemoteException {
            if (canTpNetworkSender != null && serviceActiveState) {
                FlexCanMsgPkt canMsg = new FlexCanMsgPkt();
                canMsg.CANId = CANId;
                canMsg.IDE = IDE;
                canMsg.Data = Data;
                canMsg.DataLen = DataLen;
                canTpNetworkSender.sendDataToNetworkLayer(canMsg);
            }
        }
    };


    private void initializeComponents() {
        canTpMgr = new TpInterfaceManager(dataLinkDelegateTP);
        bootloaderService = new BootloaderService(canTpMgr, this);
        applicationService = new ApplicationService(canTpMgr, this);
    }

    private final UDSService.Stub mBinder = new UDSService.Stub() {

        @Override
        public int SubmitRequest(Bundle params) throws RemoteException {
            if (params == null) {
                // Handle invalid parameters
                return -1;
            }
            ProcessRequest(params);
            return 0;
        }

        @Override
        public void RegisterUdsEventCallback(UDSEventCallback callback) {
            callbackMgr.mCallback = callback;
            if (callbackMgr.mCallback != null) {
                callbackMgr.isCallbackRegistered = true;
                callbackMgr.Log(TAG, "UDS event callback registered successfully");
            }
        }

    };

    private void unregisterUdsEventCallback() {
        if (callbackMgr != null) {
            callbackMgr.Log(TAG, "UDS event callback unregistered");
            callbackMgr.isCallbackRegistered = false;
            callbackMgr = null;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    private final DataLinkConnectorTP dataLinkDelegateTP = new DataLinkConnectorTP() {
        @Override
        public boolean transmitDataToDL(int canId, byte[] buff) {
            Boolean TransmissionResult = false;
            try {
                vcanService.vcanTransmitData(canId, buff, (byte) 8);
                TransmissionResult=true;
            } catch (RemoteException e) {
                TransmissionResult=false;
                Log.d(TAG, "Error:"+e.getMessage());
            }
            return TransmissionResult;
        }

        @Override
        public void registerReceptionFromDL(RegisterCanTpCallbackDL callback) {
            canTpNetworkSender = callback;
        }
    };


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_NOT_STICKY;
    }

    private void ProcessRequest(Bundle params) {

        // Extract parameters from the Bundle
        String UDSFlowConfiguration = params.getString("UDSFlowConfiguration");
        String ProgramFile = params.getString("ProgramFile");
        int physicalCanId = params.getInt("PhysicalCanId");
        int functionalCanId = params.getInt("FunctionalCanId");
        int responseCanId = params.getInt("ResponseCanId");
        ServiceType serviceType = ServiceType.valueOf(params.getString("ServiceType"));
        canTpMgr.setCanId(physicalCanId, functionalCanId, responseCanId);

        switch (serviceType) {
            case BOOTLOADER:
                // Process bootloader request
                processBootloaderRequest(UDSFlowConfiguration, ProgramFile);
            case APPLICATION:
                // Process application request
                processApplicationRequest(UDSFlowConfiguration);
            default:
                // Handle unsupported request
        }

    }


    private void processBootloaderRequest(String UDSFlowConfiguration, String ProgramFile) {
        if (UDSFlowConfiguration != null && ProgramFile != null) {
            final Uri xmlFileUri = Uri.parse(UDSFlowConfiguration);
            final Uri hexFileUri = Uri.parse(ProgramFile);
            if (fileExists(xmlFileUri) && fileExists(hexFileUri)) {
                executorService.execute(() -> {
                    serviceActiveState = true;
                    bootloaderService.startBootloaderService(xmlFileUri, hexFileUri);
                    serviceActiveState = false;
                    callbackMgr.operationComplete(0, "completed");
                });
            } else {
                callbackMgr.onError(2, "processBootloaderRequest: One or both files do not exist");
            }
        } else {
            callbackMgr.onError(2, "processBootloaderRequest: XML or HEX file URIs are null");
        }
    }

    private void processApplicationRequest(String UDSFlowConfiguration) {
        if (UDSFlowConfiguration != null) {
            final Uri xmlFileUri = Uri.parse(UDSFlowConfiguration);
            if (fileExists(xmlFileUri)) {
                Runnable runnable = () -> {
                    serviceActiveState = true;
                    applicationService.startApplicationService(xmlFileUri);
                    serviceActiveState = false;
                    callbackMgr.operationComplete(0, "completed");
                };
                runnable.run();
            } else {
                callbackMgr.onError(2, "processApplicationRequest: UDSFlowConfiguration file does not exist");
            }
        } else {
            callbackMgr.onError(2, "processApplicationRequest: UDSFlowConfiguration URI is null");
        }
    }

    private boolean serviceIsRunning() {
        return serviceActiveState;
    }


    private boolean fileExists(Uri uri) {
        if (uri != null) {
            ContentResolver resolver = getContentResolver();
            try {
                ParcelFileDescriptor pfd = resolver.openFileDescriptor(uri, "r");
                if (pfd != null) {
                    pfd.close();
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (vcanServiceConnected) {
            vcanServiceConnected = false;
        }
        unregisterUdsEventCallback();
        Log.d(TAG, "DiagCanServiceMain onDestroy()");
    }
}
