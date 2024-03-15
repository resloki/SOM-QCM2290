package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;
import java.util.Map;

/**
 * Implementation of ISO 14229 service 0x3E.
 * This service handles the request and response process for service 0x3E in ISO 14229.
 */
public class iso14229_serv0x3E extends DiagCanService {

    private static final String serviceName = "service Name: 0x3E,";
    private static final byte POSITIVE_RESPONSE = 0x7E;


    /**
     * Constructs a new instance of Iso14229Serv0x3E.
     *
     * @param serviceInfo Service information containing details about the service request
     * @param CANtp       Object for communicating with the ISO 15765-2 transport protocol
     */
    public iso14229_serv0x3E(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
    }


    @Override
    public int runService() {
        byte[] requestFrame;
        byte[] responseFrame = new byte[0];
        short requestFrameTotalLength;

        if (udsRequest.optionalBytesUsed) {
            // Calculate total length including optional bytes
            requestFrameTotalLength = (short) (2 + udsRequest.optionalBytes.size()); // Base length (2 for header) plus optional bytes
            requestFrame = new byte[requestFrameTotalLength];

            // Copy optional bytes into the request frame if present
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                int index = entry.getKey();
                byte value = entry.getValue();

                if (index >= 0 && index < requestFrame.length) {
                    requestFrame[index] = value;
                }
            }
        } else {
            // No optional bytes used, so base length is 2
            requestFrameTotalLength = 0x2;
            requestFrame = new byte[requestFrameTotalLength];
        }

        // Set header bytes
        if (requestFrameTotalLength < 0xFF) {
            requestFrame[0] = (byte) requestFrameTotalLength;
            requestFrame[1] = serviceID;
            requestFrame[2] = udsRequest.subfunctionID;
        } else {
            requestFrame[0] = (byte) (requestFrameTotalLength >> 8 | 0x0F);
            requestFrame[1] = (byte) requestFrameTotalLength;
            requestFrame[2] = serviceID;
            requestFrame[3] = udsRequest.subfunctionID;
        }

        diagCanTp.sendRequest(requestFrame, requestFrame.length);
        callbackMgr.Log(TAG, serviceName + " Sending request via ISO_15765tp: " + Arrays.toString(requestFrame));

        // Receive and handle the response frame from the server (ECU)
        serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
        if (response != serviceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName + "The operation timed out while awaiting the reception of Response frame from the BCM");
            return -1;
        }

        callbackMgr.Log(TAG, serviceName + " Receiving data from ISO_15765tp: " + Arrays.toString(responseFrame));

        if (udsRequest.SPR) {
            /* Positive response suppression enabled, no need to wait for a response */
            callbackMgr.Log(TAG, serviceName + " Suppressing positive response.");
            return 0;
        }

        byte nrc = -1;

        switch (responseFrame[1]) {
            case POSITIVE_RESPONSE:
                if (responseFrame[2] == requestFrame[2]) {
                    callbackMgr.Log(TAG, serviceName + " Positive Response: Request matches");
                    return 0;
                }
                break;
            case NEGATIVE_RESPONSE:
                // Handle negative response
                nrc = responseFrame[2];
                String nrcDescription = UDSErrors.getErrorDescription(nrc);
                callbackMgr.onError(nrc, serviceName + " (Tester Present) Negative Response Code: 0x" + Integer.toHexString(nrc) + " (" + nrcDescription + ")");
                break;
        }

        return nrc;
    }



}
