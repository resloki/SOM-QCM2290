package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;


/**
 * Implementation of ISO 14229 service 0x2E(Write Data By Identifier)
 * This service handles the communication control for ISO 15765-2 transport protocol.
 *
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class Iso14229Serv0x2E extends UdsDiagnosticService {

    private static final String serviceName = "service Name: 0x3E,";
    private static final byte POSITIVE_RESPONSE = 0x6E;


    /**
     * Constructs a new instance of Iso14229Serv0x2E.
     *
     * @param serviceInfo Service information containing details about the service request
     * @param Iso15765TransportIF       Object for communicating with the ISO 15765-2 transport protocol
     */


    public Iso14229Serv0x2E(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }


    @Override
    byte[] buildRequestFrame() {
        byte writingDataLength = udsRequest.dataIdentifierInfo.bufferLength;
        byte headerBytesLength = 0x04;
        byte requestFrameTotalLength = (byte) (headerBytesLength + writingDataLength);

        byte[] requestFrame = new byte[requestFrameTotalLength];

        // Extract Data Identifier and its associated name from the request
        short DataIdentifier = udsRequest.dataIdentifierInfo.number;

        requestFrame[0] = requestFrameTotalLength;
        requestFrame[1] = serviceID;
        requestFrame[2] = (byte) (DataIdentifier >> 8 | 0x0F); // MSB Byte
        requestFrame[3] = (byte) DataIdentifier; // Low byte of Data Identifier
        for (byte i = 0; i < writingDataLength; i++) {
            requestFrame[headerBytesLength + i] = udsRequest.dataIdentifierInfo.byteValues.get(i);
        }

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
                 resultCode = buildResultCode(serviceID,  SUCCESS, (byte) 0);
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


    @Override
    public int executeDiagnosticService() {
        byte[] requestFrame = buildRequestFrame();
        Iso15765TransportIF.sendRequest(requestFrame, requestFrame.length);

        // Receive and handle the response frame from the server (ECU)
        Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);
        if (Response.serviceResponse != ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS) {
            // Handle timeout
            callbackManager.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
             return buildResultCode(serviceID, (byte) FAILED, (byte) 0);
        }
        byte[] RxFrame = Response.getResponseFrame();


        return processResponse(RxFrame);
    }
}
