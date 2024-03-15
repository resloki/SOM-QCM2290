package com.royalenfield.diagcan.iso14229UDS;


import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;

public class Iso14229Serv0x35 extends DiagCanService {
    private static final String serviceName = "service Name: 0x35,";
    private static final byte POSITIVE_RESPONSE = 0x75;

    private static final String SERVICE_NAME = "Service Name: 0x35,";

    private byte startAddressMemoryUpload = 0x00; // Start address of memory to upload
    private short lengthMemoryUpload = 0x00; // Length of memory to upload


    public Iso14229Serv0x35(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
        startAddressMemoryUpload = serviceInfo.udsRequest.startAddressMemoryUpload;
        this.lengthMemoryUpload = (short) serviceInfo.udsRequest.lengthMemoryUpload;
    }


    @Override
    public int runService() {
        // Construct request frame for requesting upload
        byte[] requestFrame = constructRequestFrame();

        // Send request frame to the server (ECU)
        diagCanTp.sendRequest(requestFrame, requestFrame.length);
        callbackMgr.Log(TAG, SERVICE_NAME + " Sending request via ISO_15765tp: " + Arrays.toString(requestFrame));


        // Receive and handle the response frame from the server (ECU)
        byte[] responseFrame = new byte[0];
        serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
        if (response != serviceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return -1;
        }

        switch (responseFrame[1]) {
            case POSITIVE_RESPONSE:
                // Process positive response
                callbackMgr.Log(TAG, SERVICE_NAME + " Positive Response: Request accepted");
                // Handle memory upload process
                // (You need to implement memory upload logic here)
                break;

            case NEGATIVE_RESPONSE:
                // Handle negative response
                byte nrc = responseFrame[2];
                String nrcDescription = UDSErrors.getErrorDescription(nrc);
                callbackMgr.onError(nrc, SERVICE_NAME + " Negative Response Code: 0x" +
                        Integer.toHexString(nrc) + " (" + nrcDescription + ")");
                break;

            default:
                // Handle other cases if needed
                break;
        }


        return 0; // Return appropriate result code based on the execution
    }

    private byte[] constructRequestFrame() {
        // Construct request frame for requesting upload
        byte[] requestFrame = new byte[8];
        requestFrame[0] = 0x05; // Length of the request frame (excluding the length byte itself)
        requestFrame[1] = serviceID;
        requestFrame[2] = startAddressMemoryUpload; // Start address of memory
        requestFrame[3] = (byte) ((lengthMemoryUpload >> 8) & 0xFF); // High byte of memory length
        requestFrame[4] = (byte) (lengthMemoryUpload & 0xFF); // Low byte of memory length
        return requestFrame;
    }

}




