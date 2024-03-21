package com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities;

import java.util.HashMap;
import java.util.Map;

public class UDSNrcCodes {

    private Map<Integer, String> errorDictionary;

    public UDSNrcCodes() {
        // Initialize the dictionary
        errorDictionary = new HashMap<>();

        // Add errors to the dictionary
        errorDictionary.put(0x10, "General reject");
        errorDictionary.put(0x11, "Service not supported");
        errorDictionary.put(0x12, "Sub-function not supported");
        errorDictionary.put(0x13, "Incorrect message length or invalid format");
        errorDictionary.put(0x14, "responseTooLong");

        errorDictionary.put(0x21, "Busy repeat request");//14

        errorDictionary.put(0x22, "Conditions not correct");
        errorDictionary.put(0x23, "Request not completed");
        errorDictionary.put(0x24, "Request sequence error");
        errorDictionary.put(0x25, "No response from subnet component");
        errorDictionary.put(0x26, "Failure prevents execution of requested action");
        errorDictionary.put(0x31, "Request out of range");
        errorDictionary.put(0x33, "Security access denied");
        errorDictionary.put(0x35, "Invalid key");
        errorDictionary.put(0x36, "Exceed number of attempts");
        errorDictionary.put(0x37, "Required time delay not expired");
        errorDictionary.put(0x38, "secureDataTransmissionRequired");
        errorDictionary.put(0x39, "secureDataTransmissionNotAllowed");

        errorDictionary.put(0x4F, "SecurityAccessDeniedEnhancedSecurity");
        errorDictionary.put(0x50, "Certificate verification failed - Invalid Time Period");
        errorDictionary.put(0x51, "Certificate verification failed - Invalid Signature");
        errorDictionary.put(0x52, "Certificate verification failed - Invalid Chain of Trust");

        errorDictionary.put(0x53, "Certificate verification failed - Invalid Type");
        errorDictionary.put(0x54, "Certificate verification failed - Invalid Format");
        errorDictionary.put(0x55, "Certificate verification failed - Invalid Content");
        errorDictionary.put(0x56, "Certificate verification failed - Invalid Scope");
        errorDictionary.put(0x57, "Certificate verification failed – Invalid Certificate (revoked)");
        errorDictionary.put(0x58, "Ownership verification failed");

        errorDictionary.put(0x59, "Challenge calculation failed");

        errorDictionary.put(0x5A, "Setting Access Rights failed");

        errorDictionary.put(0x5B, "Session key creation / derivation failed");

        errorDictionary.put(0x5C, "Configuration data usage failed");

        errorDictionary.put(0x5D, "DeAuthentication failed");

        errorDictionary.put(0x70, "Upload/download not accepted");
        errorDictionary.put(0x71, "Transfer data suspended");
        errorDictionary.put(0x72, "General programming failure");
        errorDictionary.put(0x73, "Wrong block sequence counter");
        errorDictionary.put(0x78, "Request correctly received, response pending");
        errorDictionary.put(0x7A, "Sub-function not supported in current mode");
        errorDictionary.put(0x7E, "Sub-function not supported in active session");
        errorDictionary.put(0x7F, "Service not supported in active session");
        errorDictionary.put(0x81, "RPM too high");
        errorDictionary.put(0x82, "RPM too low");
        errorDictionary.put(0x83, "Engine is running");
        errorDictionary.put(0x84, "Engine is not running");
        errorDictionary.put(0x85, "Engine run time too short");
        errorDictionary.put(0x86, "Temperature too high");
        errorDictionary.put(0x87, "Temperature too low");
        errorDictionary.put(0x88, "Vehicle speed too high");
        errorDictionary.put(0x89, "Vehicle speed too low");
        errorDictionary.put(0x8A, "Throttle/Pedal too high");
        errorDictionary.put(0x8B, "Throttle/Pedal too low");

        errorDictionary.put(0x8C, "Transmission range not in neutral");
        errorDictionary.put(0x8D, "Transmission range not in gear");
        errorDictionary.put(0x8F, "Brake switch(es) not closed (brake pedal not pressed or not applied)");
        errorDictionary.put(0x90, "Shifter lever not in park");
        errorDictionary.put(0x91, "Torque converter clutch locked");
        errorDictionary.put(0x92, "Voltage too high");
        errorDictionary.put(0x93, "Voltage too low");
        errorDictionary.put(0x94, "ResourceTemporarilyNotAvailable");
        errorDictionary.put(0xFF, "Response not received from CAN TP");

    }

    public String getErrorDescription(int errorCode) {
        return errorDictionary.getOrDefault(errorCode, "Invalid Response");
    }
}
