package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.Map;



/**
 * This class implements a specific UDS diagnostic service with service ID 0x28,
 * which is used for Communication Control according to ISO 14229 standard.
 * This service allows managing the communication mode and parameters between
 * the diagnostic tool and the ECU.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x28. It handles the following:
 *
 * 1. Building the request frame with subfunction ID and communication type.
 * 2. Optionally including additional parameters in the request frame based on configuration.
 * 3. Sending the request frame to the ECU.
 * 4. Receiving and processing the ECU's response, indicating success, failure, or timeout.
 * 5. Logging diagnostic information for debugging purposes.
 */
public class Iso14229Serv0x28 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x11,";
    private static final byte POSITIVE_RESPONSE = (byte) 0x84;


    public Iso14229Serv0x28(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }


    /**
     * Builds the request frame with DTC information.
     *
     * @return The constructed request frame.
     */
    @Override
    byte[] buildRequestFrame() {
        byte[] requestFrame;

        short requestFrameTotalLength;

        if (udsRequest.optionalBytesUsed) {
            // Calculate total length including optional bytes
            requestFrameTotalLength = (short) (4 + udsRequest.optionalBytes.size()); // Base length (2 for header) plus optional bytes
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
            requestFrameTotalLength = 0x04;
            requestFrame = new byte[requestFrameTotalLength];
        }

        // Set header bytes
        requestFrame[0] = serviceID;
        requestFrame[1] = udsRequest.subfunctionID;
        requestFrame[2] = udsRequest.CommunicationType.getKey();
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
