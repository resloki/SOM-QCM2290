package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;
import java.util.Map;


/**
 * Implementation of ISO 14229 service 0x22 (Read Data By Identifier).
 * This service reads data identified by a specific Data Identifier (DID) from the ECU.
 */
public class Iso14229Serv0x22 extends DiagCanService {

    // Constants for positive and negative response bytes
    private static final byte POSITIVE_RESPONSE = 0x62;


    /**
     * Constructs a new instance of Iso14229Serv0x22.
     *
     * @param serviceInfo Service information containing details about the service request
     * @param CANtp       Object for communicating with the ISO 15765-2 transport protocol
     */
    public Iso14229Serv0x22(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
    }

    @Override
    int runService() {
        byte[] requestFrame = new byte[8];
        if (udsRequest.optionalBytesUsed) {
            // Copy optional bytes into the request buffer if present
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                int index = entry.getKey();
                byte value = entry.getValue();
                if (index >= 0 && index < requestFrame.length) {
                    requestFrame[index] = value;
                }
            }
        }

        // Extract Data Identifier and its associated name from the request
        short DataIdentifier = udsRequest.dataIdentifierInfo.number;
        String dataIdentifierName = udsRequest.dataIdentifierInfo.name;


        // Construct the request frame
        requestFrame[0] = 0x03;   // Request Frame Length
        requestFrame[1] = serviceID; // Service Identifier for Diagnostic Session Control
        requestFrame[2] = (byte) (DataIdentifier >> 8 | 0x0F); // High byte of Data Identifier
        requestFrame[3] = (byte) DataIdentifier; // Low byte of Data Identifier

        // Send the request frame
        diagCanTp.sendRequest(requestFrame, requestFrame.length);
        callbackMgr.Log(TAG, serviceName + " Sending request via ISO_15765tp: " + Arrays.toString(requestFrame));

        // Receive and handle the response frame from the server (ECU)
        byte[] responseFrame = new byte[0];
        serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
        if (response != serviceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return -1;
        }


        // Process the response
        callbackMgr.Log(TAG, serviceName + " Receiving data from ISO_15765tp: " + Arrays.toString(responseFrame));
        byte nrc = -1;

        switch (responseFrame[1]) {
            case POSITIVE_RESPONSE:
                // Notify callback about available data
                callbackMgr.onDataAvailable(responseFrame, serviceID, DataIdentifier,dataIdentifierName);
                break;
            case NEGATIVE_RESPONSE:
                // Handle negative response
                nrc = responseFrame[2];
                String nrcDescription = UDSErrors.getErrorDescription(nrc);
                callbackMgr.onError(nrc, serviceName + "Negative Response Code: 0x" + Integer.toHexString(nrc) + " (" + nrcDescription + ")");
                break;
            default:
                // Handle other cases if needed
                break;
        }


        return 0;
    }
}