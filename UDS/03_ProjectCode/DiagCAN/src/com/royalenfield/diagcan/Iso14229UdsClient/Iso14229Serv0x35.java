package com.royalenfield.diagcan.Iso14229UdsClient;


import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;


/**
 * This class implements a specific UDS diagnostic service with service ID 0x35,
 * which is used for Request Download according to ISO 14229 standard.
 * This service initiates the transfer of a block of memory data from the ECU
 * to the diagnostic tool for various purposes (e.g., calibration data backup).
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x35. It handles the following:
 *
 * 1. Building the request frame with start address and length of the memory area to be downloaded.
 * 2. Sending the request frame to the ECU.
 * 3. Receiving and processing the ECU's response, indicating success, failure, or timeout.
 * 4. Logging diagnostic information for debugging purposes.
 */
public class Iso14229Serv0x35 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x35,";
    private static final byte POSITIVE_RESPONSE = 0x75;

    private static final String SERVICE_NAME = "Service Name: 0x35,";

    private byte startAddressMemoryUpload = 0x00; // Start address of memory to upload
    private short lengthMemoryUpload = 0x00; // Length of memory to upload


    public Iso14229Serv0x35(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
        startAddressMemoryUpload = serviceInfo.udsRequest.startAddressMemoryUpload;
        this.lengthMemoryUpload = (short) serviceInfo.udsRequest.lengthMemoryUpload;
    }


    @Override
    byte[] buildRequestFrame() {
        byte[] requestFrame = new byte[8];
        requestFrame[0] = 0x05; // Length of the request frame (excluding the length byte itself)
        requestFrame[1] = serviceID;
        requestFrame[2] = startAddressMemoryUpload; // Start address of memory
        requestFrame[3] = (byte) ((lengthMemoryUpload >> 8) & 0xFF); // High byte of memory length
        requestFrame[4] = (byte) (lengthMemoryUpload & 0xFF); // Low byte of memory length
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




