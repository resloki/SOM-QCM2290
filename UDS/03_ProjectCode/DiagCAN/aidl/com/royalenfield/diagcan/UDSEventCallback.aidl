// UDSEventCallback.aidl
package com.royalenfield.diagcan;
import android.os.Bundle;
// This interface is responsible for providing callbacks from the UDS service to the FOTA manager,
// allowing the FOTA manager to receive status updates and execution statuses of services.
interface UDSEventCallback {
     // Method to provide detailed progress updates during UDS service operations.
        void progressUpdate(int progress);

        void udsLog(String Message);

        // Method to notify the FOTA manager when a UDS service operation completes successfully.
        void operationComplete(int status, String Message);

        // Method to notify the FOTA manager of any errors or exceptions encountered during UDS service operations.
        void onError(int errorCode, String errorMessage);

        // Method to indicate the availability of new data or updates from the UDS service.
        void onDataAvailable(out  Bundle operationData);

        // Method to notify the FOTA manager when the UDS service encounters a critical failure.
        void onCriticalFailure(int statusEn, String errorMessage);


}
