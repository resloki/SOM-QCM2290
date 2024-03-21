package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;


/**
 * This class implements a specific UDS diagnostic service with service ID 0x14,
 * which is used to Clear DTC by Identifier according to ISO 14229 standard.
 * This service allows clearing specific Diagnostic Trouble Codes (DTCs) stored in the ECU.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x14. It handles building the CAN request
 * frame with DTC identifiers (defaulting to all if not specified), processing the received response frame,
 * and interpreting the results to confirm successful DTC clearing or handle any errors reported by the ECU.
 */
public class Iso14229Serv0x14 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x11,";
    private static final byte POSITIVE_RESPONSE = 0x51;


    public Iso14229Serv0x14(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }

    @Override
    byte[] buildRequestFrame() {
        byte requestFrameTotalLength = 0x08;  // Adjusted for subfunction ID
        byte[] requestFrame = new byte[requestFrameTotalLength];

        requestFrame[0] = requestFrameTotalLength;
        requestFrame[1] = serviceID;
        requestFrame[2] = udsRequest.subfunctionID;
        requestFrame[3] = (byte) 0xff; // Group of DTC (default to all)
        requestFrame[4] = (byte) 0xff; // Group of DTC (default to all)
        requestFrame[5] = (byte) 0xff; // Group of DTC (default to all)
        requestFrame[6] = (byte) 0xff; // Status byte (optional)


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

        return resultCode; // Or return a specific error code
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
