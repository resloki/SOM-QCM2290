// UDSService.aidl
package com.royalenfield.diagcan;
import com.royalenfield.diagcan.UDSEventCallback;
// This interface defines the methods that the FOTA manager can call to interact with the UDS service.
// It includes methods for submitting requests related to bootloader and application updates.

interface UDSService {
    /**
    * Method to submit a bootloader or application request to the UDS service.
    */
    int SubmitRequest(in Bundle params);


    /**
     * Method to register a callback for receiving events and updates from the UDS service.
     *
     * @param callback The callback interface to be registered.
     */
     void RegisterUdsEventCallback(UDSEventCallback callback);
}