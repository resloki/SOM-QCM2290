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


import com.royalenfield.diagcan.Iso14229UdsClient.ApplicationService;
import com.royalenfield.diagcan.Iso14229UdsClient.BootloaderService;
import com.royalenfield.diagcan.Iso14229UdsClient.UdsSession.ServiceType;
import com.royalenfield.diagcan.iso15765TP.DataLinkConnectorTP;
import com.royalenfield.diagcan.iso15765TP.RegisterCanTpCallbackDL;
import com.royalenfield.diagcan.iso15765TP.TpInterfaceManager;
import com.royalenfield.uartservice.VcanCommunicationCallback;
import com.royalenfield.uartservice.VcanCommunicationInterface;


import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CanDiagnosticServicesClient extends Service {

    private static final String TAG = "CanDiagnosticServicesClient";

    private BootloaderService bootloaderService;
    private ApplicationService applicationService;
    private boolean isTaskInProgress = false;

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


    /**
     * Private final reference to the UDSService.Stub object, used for client-server interaction.
     */
    private final UDSService.Stub mBinder = new UDSService.Stub() {
        /**
         * Submits a request to the UDS service for processing.
         *
         * @param params Bundle containing request parameters.
         * @return 0 on successful submission, -1 on invalid parameters.
         * @throws RemoteException If a remote communication error occurs.
         */
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
                callbackMgr.log(TAG, "UDS event callback registered successfully");
            }
        }

    };



    private void unregisterUdsEventCallback() {
        if (callbackMgr != null) {
            callbackMgr.log(TAG, "UDS event callback unregistered");
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

    /**
     * Processes a request received from the client application through the UDS service.
     *
     * @param params Bundle containing request parameters.
     */
    private void ProcessRequest(Bundle params) {

        // Extract parameters from the Bundle with descriptive variable names
        String udsFlowConfiguration = params.getString("UDSFlowConfiguration");
        String programFile = params.getString("ProgramFile");  // Likely for bootloader updates
        int physicalCanId = params.getInt("PhysicalCanId");
        int functionalCanId = params.getInt("FunctionalCanId");
        int responseCanId = params.getInt("ResponseCanId");
        ServiceType serviceType;
        try {
            serviceType = ServiceType.valueOf(params.getString("ServiceType"));
        } catch (IllegalArgumentException e) {
            // Handle invalid ServiceType value
            callbackMgr.operationComplete(-1, "Invalid ServiceType provided in request!");
            return;
        }


        /*  Set CAN IDs in the CAN TP manager (assuming canTpMgr is a relevant object)  */
        canTpMgr.setCanId(physicalCanId, functionalCanId, responseCanId);

        switch (serviceType) {
            case BOOTLOADER_SERVICE:
                /**
                 * Processes a bootloader update request.
                 *
                 * @param udsFlowConfiguration The UDS flow configuration for the ECU update.
                 * @param programFile The path to the program file for the bootloader update.
                 */
                processBootloaderRequest(udsFlowConfiguration, programFile);
                break;
            case APPLICATION_SERVICE:
                /**
                 * Processes an application update request.
                 *
                 * @param udsFlowConfiguration The UDS flow configuration for the application update.
                 */
                processApplicationRequest(udsFlowConfiguration);
                break;
            default:
                // Handle unsupported service type
                Log.w(TAG, "Unsupported service type: " + serviceType);
        }
    }



    /**
     * Processes a bootloader update request.
     *
     * @param UDSFlowConfiguration URI representing the UDS flow configuration file.
     * @param ProgramFile URI representing the program file for the bootloader update.
     */
    private void processBootloaderRequest(String UDSFlowConfiguration, String ProgramFile) {

        /* Check if both URIs are valid and files exist */
        if (UDSFlowConfiguration != null && ProgramFile != null) {
            final Uri TemplateUri = Uri.parse(UDSFlowConfiguration);
            final Uri firmwareImageFileURI = Uri.parse(ProgramFile);
            if (fileExists(TemplateUri) && fileExists(firmwareImageFileURI)) {
                /* Execute update task on a background thread */
                executorService.execute(() -> {
                    /**
                     * Set a flag indicating a task is in progress (optional for UI updates).
                     */
                    isTaskInProgress = true;

                    /**
                     * Call bootloader service to start the update process with the provided URIs.
                     * - TemplateUri: URI for the UDS flow configuration file.
                     * - firmwareImageFileURI: URI for the program file.
                     */
                    bootloaderService.startBootloaderService(TemplateUri, firmwareImageFileURI);

                    /**
                     * Reset the task progress flag after completion.
                     */
                    isTaskInProgress = false;

                    /**
                     * Notify callback manager about successful completion with a code and message.
                     * - Code: 0 (indicating success, adjust based on your implementation)
                     * - Message: "completed" (consider using a more descriptive message)
                     */
                    callbackMgr.operationComplete(0, "completed");
                });
            } else {
                /**
                 * Handle case where files don't exist.
                 * - Code: 2 (indicating an error, adjust based on your implementation)
                 * - Message: "processBootloaderRequest: One or both files do not exist"
                 */
                callbackMgr.operationComplete(0, "Input files don't exist");
                callbackMgr.onError(2, "processBootloaderRequest: One or both files do not exist");
            }
        } else {
            /**
             * Handle case where URIs are null.
             * - Code: 2 (indicating an error, adjust based on your implementation)
             * - Message: "processBootloaderRequest: XML or HEX file URIs are null"
             */
            callbackMgr.operationComplete(0, "Input files URIs are null");
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
