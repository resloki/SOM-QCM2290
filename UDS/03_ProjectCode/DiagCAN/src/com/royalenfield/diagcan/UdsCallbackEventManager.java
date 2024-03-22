package com.royalenfield.diagcan;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import java.util.Arrays;


/**
 * The UdsCallbackEventManager class manages event callbacks for UDS (Unified Diagnostic Services).
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class UdsCallbackEventManager {
    private static final String TAG = "UdsCallback";
    private static UdsCallbackEventManager instance;
    protected UDSEventCallback mCallback;
    protected boolean isCallbackRegistered = false;

    public static synchronized UdsCallbackEventManager getInstance() {
        if (instance == null) {
            instance = new UdsCallbackEventManager();
        }
        return instance;
    }

    /**
     * Notifies the registered callback about progress update.
     *
     * @param totalBytes   Total bytes.
     * @param currentByte  Current byte.
     */
    public void progressUpdate(int totalBytes, int currentByte) {
        if (isCallbackRegistered()) {
            try {
                mCallback.progressUpdate(totalBytes,currentByte);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in progressUpdate: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Logs a message and notifies the registered callback.
     *
     * @param TAG     The tag for logging.
     * @param message The message to be logged and notified.
     */
    public void log(String TAG, String message) {
        if (isCallbackRegistered()) {
            try {
                mCallback.udsLog(message);
                Log.d(TAG, "UDS Log: " + message);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in progressUpdate: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Notifies the registered callback about operation completion.
     *
     * @param status  The status code.
     * @param message The message describing the completion status.
     */
    public void operationComplete(int status, String message) {
        if (isCallbackRegistered()) {
            try {
                mCallback.operationComplete(status, message);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in operationComplete: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Notifies the registered callback about an error.
     *
     * @param errorCode    The error code.
     * @param errorMessage The error message.
     */
    public void onError(int errorCode, String errorMessage) {
        if (isCallbackRegistered()) {
            try {
                mCallback.onError(errorCode, errorMessage+"\n");
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in onError: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Notifies the registered callback about available data.
     *
     * @param data         The data array.
     * @param SID          The Service Identifier.
     * @param Parameter    The parameter.
     * @param ParameterName The parameter name.
     */
    public void onDataAvailable(byte[] data, int SID, int Parameter, String ParameterName) {
        if (isCallbackRegistered()) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("SID", SID);
                bundle.putString("ParameterName", ParameterName);
                bundle.putString("ParameterValue", ParameterName);
                bundle.putByteArray("ResponseData", data);
                mCallback.onDataAvailable(bundle);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in onCriticalFailure: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        Log.d(TAG, "Data available: " + Arrays.toString(data));
    }

    /**
     * Notifies the registered callback about a critical failure.
     *
     * @param statusEn     The status code.
     * @param errorMessage The error message.
     */
    public void onCriticalFailure(int statusEn, String errorMessage) {
        if (isCallbackRegistered()) {
            try {
                mCallback.onCriticalFailure(statusEn,errorMessage);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in onCriticalFailure: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    boolean isCallbackRegistered() {
        return isCallbackRegistered;
    }
}
