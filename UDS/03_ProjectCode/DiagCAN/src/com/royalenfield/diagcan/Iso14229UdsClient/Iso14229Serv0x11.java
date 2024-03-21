package com.royalenfield.diagcan.Iso14229UdsClient;


import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.Map;


/**
 * This class implements a specific UDS diagnostic service with service ID 0x11,
 * which is used for Diagnostic Information Access according to ISO 14229 standard.
 * This service allows retrieval of various diagnostic information from the Electronic Control Unit (ECU).
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x11. It handles building the CAN request
 * frame with optional diagnostic information identifiers, processing the received response frame,
 * and interpreting the results to access requested diagnostic data from the ECU.
 */
public class Iso14229Serv0x11 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x11,";
    private static final byte POSITIVE_RESPONSE = 0x51;


    public Iso14229Serv0x11(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }


    @Override
    int processResponse(byte[] RxFrame) {
        byte nrc = -1;
        int resultCode;

        if (udsResponse.expectResponseData) {
            callbackManager.onDataAvailable(RxFrame, serviceID, udsRequest.subfunctionID, udsRequest.status);
        }

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
                // Handle other cases if needed
                resultCode = -1; // Or define a specific error code
                break;
        }

        return resultCode;
    }


    @Override
    byte[] buildRequestFrame() {
        short requestFrameTotalLength;
        byte[] requestFrame = null;
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
            return requestFrame;
        } else {
            // No optional bytes used, so base length is 2
            requestFrameTotalLength = 0x2;
            requestFrame = new byte[requestFrameTotalLength];
        }

        // Set header bytes
        requestFrame[0] = serviceID;
        requestFrame[1] = udsRequest.subfunctionID;

        return requestFrame;
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

