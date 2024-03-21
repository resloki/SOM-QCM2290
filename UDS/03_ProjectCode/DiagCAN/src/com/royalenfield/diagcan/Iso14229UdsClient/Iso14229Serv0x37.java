package com.royalenfield.diagcan.Iso14229UdsClient;


import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.Map;

/**
 * This class implements a specific UDS diagnostic service with service ID 0x37,
 * which is used for Request Transfer Exit according to ISO 14229 standard.
 * This service signals the completion of a block-by-block data transfer initiated
 * with service ID 0x36 (Transfer Data Block).
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x37. It handles the following:
 *
 * 1. Building the request frame with optional bytes, if specified.
 * 2. Sending the request frame to the ECU using the ISO 15765 transport layer.
 * 3. Receiving and processing the ECU's response, indicating success (Positive Response) or failure (Negative Response Code, NRC).
 * 4. Handling the Suppress Positive Response (SPR) mode where no response is expected.
 * 5. Logging diagnostic information for debugging purposes.
 */
public class Iso14229Serv0x37 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x37,";
    private static final byte POSITIVE_RESPONSE = 0x77;


    public Iso14229Serv0x37(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }


    /**
     * Builds the request frame based on the presence of optional bytes.
     *
     * @return The constructed request frame.
     */
    @Override
    byte[] buildRequestFrame() {
        short requestFrameTotalLength;

        if (udsRequest.optionalBytesUsed) {
            // Calculate total length including optional bytes
            requestFrameTotalLength = (short) (1 + udsRequest.optionalBytes.size()); // Base length (2 for header) plus optional bytes
        } else {
            // No optional bytes used, so base length is 2
            requestFrameTotalLength = 0x01;
        }

        byte[] requestFrame = new byte[requestFrameTotalLength];

        // Set header byte
        requestFrame[0] = serviceID;

        // Copy optional bytes if present
        if (udsRequest.optionalBytesUsed) {
            int index = 1;
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                byte value = entry.getValue();
                requestFrame[index] = value;
                index++;
            }
        }

        return requestFrame;
    }





    /**
     * Processes the received response frame based on its content.
     *
     * @param RxFrame The received response frame data.
     * @return 0 on success, negative value on NRC (error) or -1 on failure.
     */
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



