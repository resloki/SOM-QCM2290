package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;


/**
 * This class implements a specific UDS diagnostic service with service ID 0x2F,
 * which is used for Input/Output Control by Identifier. It allows an external system
 * to intervene on internal or external signals via the diagnostic interface.
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x2F. It handles building the CAN request
 * frame with appropriate options and parameters, processing the received response frame,
 * and interpreting the results to control or monitor input/output signals on the ECU.
 *
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */

public class Iso14229Serv0x2F extends UdsDiagnosticService {

    private static final String serviceName = "service Name: 0x3E,";
    private static final byte POSITIVE_RESPONSE = 0x6F;
    private static final byte SHORT_TERM_ADJUSTMENT = 0x03;


    /**
     * Constructs a new instance of Iso14229Serv0x2F.
     *
     * @param serviceInfo Service information containing details about the service request
     * @param Iso15765TransportIF       Object for communicating with the ISO 15765-2 transport protocol
     */
    public Iso14229Serv0x2F(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }

    @Override
    byte[] buildRequestFrame() {
        byte headerBytesLength = 0x05;
        byte requestFrameTotalLength;
        byte[] requestFrame;

        // Extract Data Identifier and its associated name from the request
        short DataIdentifier = udsRequest.dataIdentifierInfo.number;
        String dataIdentifierName = udsRequest.dataIdentifierInfo.name;
        byte IOCP = udsRequest.IOCP.getKey();

        if (IOCP == SHORT_TERM_ADJUSTMENT) {
            byte dataRecordLength = udsRequest.dataIdentifierInfo.bufferLength;
            requestFrameTotalLength = (byte) (headerBytesLength + dataRecordLength);
            requestFrame = new byte[requestFrameTotalLength];
            requestFrame[0] = requestFrameTotalLength; // Service Identifier for ISO 14229 service 0x2F
            requestFrame[1] = serviceID;
            requestFrame[2] = (byte) (DataIdentifier >> 8 | 0x0F); // MSB Byte
            requestFrame[3] = (byte) DataIdentifier; // LSB Byte
            requestFrame[4] = IOCP;
            for (byte i = 0; i < dataRecordLength; i++) {
                requestFrame[headerBytesLength + i] = udsRequest.dataIdentifierInfo.byteValues.get(i);
            }
        } else {
            requestFrameTotalLength = headerBytesLength;
            requestFrame = new byte[requestFrameTotalLength];
            requestFrame[0] = requestFrameTotalLength; // Service Identifier for ISO 14229 service 0x2F
            requestFrame[1] = serviceID;
            requestFrame[2] = (byte) (DataIdentifier >> 8 | 0x0F); // MSB Byte
            requestFrame[3] = (byte) DataIdentifier; // LSB Byte
            requestFrame[4] = IOCP;
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
