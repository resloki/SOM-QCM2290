package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;



/**
 * This class implements a specific UDS diagnostic service with service ID 0x19,
 * which is used to Read DTC Information according to ISO 14229 standard.
 * This service allows retrieving Diagnostic Trouble Code (DTC) information from the Electronic Control Unit (ECU).
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x19. It handles building the CAN request
 * frame with DTC format ID, filtering mode, and additional mask based on user configuration,
 * processing the received response frame, and interpreting the results to provide DTC details
 * to the diagnostic tool or application.
 */

public class Iso14229Serv0x19 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x11,";
    private static final byte POSITIVE_RESPONSE = 0x51;


    public Iso14229Serv0x19(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }


    /**
     * Builds the request frame with DTC information.
     *
     * @return The constructed request frame.
     */
    @Override
    byte[] buildRequestFrame() {
        byte[] requestFrame = new byte[5];

        requestFrame[0] = serviceID;                        // Service ID for Read DTC Information
        requestFrame[1] = udsRequest.subfunctionID;  // Subfunction ID
        requestFrame[2] = udsRequest.DTCInfo.getFormatID();        // DTC format ID
        requestFrame[3] = udsRequest.DTCInfo.getMode();            // Mode for DTC filtering
        requestFrame[4] = udsRequest.DTCInfo.getMode();            // Mask for additional filtering within the chosen mode

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
