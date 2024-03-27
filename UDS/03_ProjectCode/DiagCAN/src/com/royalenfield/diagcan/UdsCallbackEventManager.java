package com.royalenfield.diagcan;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import java.util.Arrays;

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

    public void progressUpdate(int totalBytes, int currentByte) {
        if (isCallbackRegistard()) {
            try {
                mCallback.progressUpdate(totalBytes,currentByte);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in progressUpdate: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void log(String TAG, String message) {
        if (isCallbackRegistard()) {
            try {
                mCallback.udsLog(message);
                Log.d(TAG, "UDS Log: " + message);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in progressUpdate: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void operationComplete(int status, String message) {
        if (isCallbackRegistard()) {
            try {
                mCallback.operationComplete(status, message);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in operationComplete: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void onError(int errorCode, String errorMessage) {
        if (isCallbackRegistard()) {
            try {
                mCallback.onError(errorCode, errorMessage+"\n");
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in onError: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void onDataAvailable(byte[] data, int SID, int Parameter, String ParameterName) {
        if (isCallbackRegistard()) {
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

    public void onCriticalFailure(int statusEn, String errorMessage) {
        if (isCallbackRegistard()) {
            try {
                mCallback.onCriticalFailure(statusEn,errorMessage);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException occurred in onCriticalFailure: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    boolean isCallbackRegistard() {
        return isCallbackRegistered;
    }
}
