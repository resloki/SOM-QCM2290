package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.Map;


/**
 * Implementation of ISO 14229 service 0x10 (Diagnostic Session Control).
 * This service is used to control the diagnostic session.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class Iso14229Serv0x10 extends UdsDiagnosticService {
    // Constants for service name and response bytes

    private static final byte POSITIVE_RESPONSE = 0x50;

    /**
     * Constructs a new instance of Iso14229Serv0x10.
     *
     * @param serviceInfo  Service information containing details about the service request
     * @param udsInterface Object for communicating with the ISO 15765-2 transport protocol
     */

    public Iso14229Serv0x10(ServiceInfo serviceInfo, Iso15765TpInterface udsInterface) {
        super(serviceInfo, udsInterface);
    }


    @Override
    byte[] buildRequestFrame() {
        short requestFrameTotalLength;

        if (udsRequest.optionalBytesUsed) {
            // Calculate total length including optional bytes
            requestFrameTotalLength = (short) (2 + udsRequest.optionalBytes.size());
            byte[] requestFrame = new byte[requestFrameTotalLength];

            // Copy optional bytes into the request frame if present
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                int index = entry.getKey();
                byte value = entry.getValue();
                if (index >= 0 && index < requestFrame.length) {
                    requestFrame[index] = value;
                }
            }
            return requestFrame;
        } else {
            // No optional bytes used, so base length is 2
            return new byte[]{serviceID, udsRequest.subfunctionID};
        }
    }

    @Override
    int processResponse(byte[] RxFrame) {
        int resultCode;

        if (udsResponse.expectResponseData) {
            callbackManager.onDataAvailable(RxFrame, serviceID, udsRequest.subfunctionID, udsRequest.status);
        }
        byte nrc = -1;
        switch (RxFrame[1]) {

            case POSITIVE_RESPONSE:
                if (!udsRequest.SPR) {
                    callbackManager.log(TAG, processName + " Success");
                }
                resultCode = buildResultCode(serviceID, SUCCESS, (byte) 0);
                break;

            case NEGATIVE_RESPONSE:
                // Handle negative response
                nrc = RxFrame[2];
                resultCode = buildResultCode(serviceID, NEGATIVE_RESPONSE, nrc);
                break;
            default:
                resultCode = buildResultCode(serviceID, nrc, (byte) -1); // Unknown response
                break;
        }

        return resultCode;
    }


    @Override
    public int executeDiagnosticService() {
        /**
         * Builds the request frame based on optional bytes provided in the service request object.
         */
        byte[] requestFrame = buildRequestFrame();

        /**
         * Sends the request frame to the server (ECU) using the ISO 15765 transport protocol (TP).
         */
        Iso15765TransportIF.sendRequest(requestFrame, requestFrame.length);

        /**
         * Reads the response frame from the server (ECU) with a specified timeout.
         */
        Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);

        /**
         * Handles timeout scenario if no response is received within the specified time.
         */
        if (Response.serviceResponse != ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS) {
            callbackManager.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return buildResultCode(serviceID, (byte) FAILED, (byte) 0);
        }

        /**
         * Retrieves the response frame data from the Response object.
         */
        byte[] RxFrame = Response.getResponseFrame();


        /**
         * Processes the received response frame to determine the service outcome.
         */
        return processResponse(RxFrame);
    }


}