package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;


/**
 * Implementation of ISO 14229 service 0x2E(Write Data By Identifier)
 * This service handles the communication control for ISO 15765-2 transport protocol.
 */
public class Iso14229Serv0x2E extends DiagCanService {

    private static final String serviceName = "service Name: 0x3E,";
    private static final byte POSITIVE_RESPONSE = 0x6E;


    /**
     * Constructs a new instance of Iso14229Serv0x2E.
     *
     * @param serviceInfo Service information containing details about the service request
     * @param CANtp       Object for communicating with the ISO 15765-2 transport protocol
     */


    public Iso14229Serv0x2E(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
    }


    @Override
    int runService() {
        byte writingDataLength = udsRequest.dataIdentifierInfo.bufferLength;
        byte headerBytesLength = 0x04;
        byte requestFrameTotalLength = (byte) (headerBytesLength + writingDataLength);


        byte[] requestFrame = new byte[requestFrameTotalLength];
        byte[] responseFrame = new byte[8];

        // Extract Data Identifier and its associated name from the request
        short DataIdentifier = udsRequest.dataIdentifierInfo.number;
        String dataIdentifierName = udsRequest.dataIdentifierInfo.name;

        requestFrame[0] = requestFrameTotalLength;
        requestFrame[1] = serviceID;
        requestFrame[2] = (byte) (DataIdentifier >> 8 | 0x0F); //MSB Byte
        requestFrame[3] = (byte) DataIdentifier; // Low byte of Data Identifier
        for (byte i = 0; i < writingDataLength; i++) {
            requestFrame[headerBytesLength + i] = udsRequest.dataIdentifierInfo.byteValues.get(i);
        }


        // Send the request frame
        diagCanTp.sendRequest(requestFrame, requestFrame.length);
        callbackMgr.Log(TAG, serviceName + " Sending request via ISO_15765tp: " + Arrays.toString(requestFrame));

        // Receive and handle the response frame from the server (ECU)

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
                callbackMgr.onDataAvailable(responseFrame, serviceID,  DataIdentifier,dataIdentifierName);
                return 0;

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
