package com.royalenfield.diagcan.iso15765TP;

import android.os.Bundle;

public interface UDSEventCallback {
    // Method to provide detailed progress updates during UDS service operations.
    void progressUpdate(int progress);

    void udsLog(String Message);

    // Method to notify the FOTA manager when a UDS service operation completes successfully.
    void operationComplete(int status, String Message);

    // Method to notify the FOTA manager of any errors or exceptions encountered during UDS service operations.
    void onError(int errorCode, String errorMessage);

    // Method to indicate the availability of new data or updates from the UDS service.
    void onDataAvailable(Bundle operationData);

    // Method to notify the FOTA manager when the UDS service encounters a critical failure.
    void onCriticalFailure(int statusEn, String errorMessage);

}
