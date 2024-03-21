package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.Map;


/**
 * Implementation of ISO 14229 service 0x22 (Read Data By Identifier).
 * This service reads data identified by a specific Data Identifier (DID) from the ECU.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class Iso14229Serv0x22 extends UdsDiagnosticService {

    // Constants for positive and negative response bytes
    private static final byte POSITIVE_RESPONSE = 0x62;
    private static final int REQUEST_FRAME_HEADER_LENGTH = 4;

    /**
     * Constructs a new instance of Iso14229Serv0x22.
     *
     * @param serviceInfo Service information containing details about the service request
     * @param Iso15765TransportIF       Object for communicating with the ISO 15765-2 transport protocol
     */
    public Iso14229Serv0x22(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }



    @Override
    byte[] buildRequestFrame() {
        int requestFrameTotalLength = udsRequest.optionalBytesUsed ?
                REQUEST_FRAME_HEADER_LENGTH + udsRequest.optionalBytesBufferLength :
                REQUEST_FRAME_HEADER_LENGTH;
        byte[] requestFrame = new byte[requestFrameTotalLength];
        if (udsRequest.optionalBytesUsed) {
            addOptionalBytes(requestFrame);
        }
        int dataIdentifier = udsRequest.dataIdentifierInfo.number;
        setHeaderBytes(requestFrame, requestFrameTotalLength, dataIdentifier);
        return requestFrame;
    }


    @Override
    int processResponse(byte[] RxFrame) {
        int resultCode = -1;

        if (udsResponse.expectResponseData) {
            callbackManager.onDataAvailable(RxFrame, serviceID, udsRequest.subfunctionID, udsRequest.status);
        }

        switch (RxFrame[1]) {
            case POSITIVE_RESPONSE:
                 resultCode = buildResultCode(serviceID, SUCCESS, (byte) 0);
                break;

            case NEGATIVE_RESPONSE:
                // Handle negative response
                resultCode = buildResultCode(serviceID, NEGATIVE_RESPONSE, RxFrame[2]);
                break;
            default:
                // Handle other cases if needed
                break;
        }
        return resultCode;
    }


    private byte[] createRequestFrame() {
        int requestFrameTotalLength = udsRequest.optionalBytesUsed ?
                REQUEST_FRAME_HEADER_LENGTH + udsRequest.optionalBytesBufferLength :
                REQUEST_FRAME_HEADER_LENGTH;
        byte[] requestFrame = new byte[requestFrameTotalLength];
        if (udsRequest.optionalBytesUsed) {
            addOptionalBytes(requestFrame);
        }
        int dataIdentifier = udsRequest.dataIdentifierInfo.number;
        setHeaderBytes(requestFrame, requestFrameTotalLength, dataIdentifier);

        return requestFrame;
    }


    private void setHeaderBytes(byte[] requestFrame, int requestFrameTotalLength, int dataIdentifier) {
        if (requestFrameTotalLength < 0xFF) {
            requestFrame[0] = (byte) requestFrameTotalLength;
            requestFrame[1] = serviceID;
            requestFrame[2] = (byte) (dataIdentifier >> 8 | 0x0F);
            requestFrame[3] = (byte) dataIdentifier;
        } else {
            requestFrame[0] = (byte) (requestFrameTotalLength >> 8 | 0x0F);
            requestFrame[1] = (byte) requestFrameTotalLength;
            requestFrame[2] = serviceID;
            requestFrame[3] = (byte) (dataIdentifier >> 8 | 0x0F);
            requestFrame[4] = (byte) dataIdentifier;
        }
    }


    private void handleError(String message) {
        callbackManager.onCriticalFailure(RESPONSE_FAILED, processName + message);
    }


    protected void addOptionalBytes(byte[] requestFrame) {
        // Copy optional bytes into the request frame if present
        for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
            int index = entry.getKey();
            byte value = entry.getValue();

            if (index >= 0 && index < requestFrame.length) {
                requestFrame[index] = value;
            }
        }
    }


    @Override
    public int executeDiagnosticService() {
        /**
         * Builds the request frame based on optional bytes and data identifier using the `buildRequestFrame` method.
         */
        byte[] requestFrame = buildRequestFrame();

        /**
         * Sends the request frame to the server (ECU) via ISO 15765 transport protocol (TP).
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
         * Logs information about receiving the response data.
         */


        /**
         * Processes the received response frame to determine the service outcome using the `processResponse` method.
         */
        return processResponse(RxFrame);
    }


}