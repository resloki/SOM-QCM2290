package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;

public class Iso14229Serv0x19 extends DiagCanService {
    private static final String serviceName = "service Name: 0x11,";
    private static final byte POSITIVE_RESPONSE = 0x51;


    public Iso14229Serv0x19(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
    }


    @Override
    public int runService() {
        byte[] requestFrame = new byte[8];
        byte[] responseFrame = new byte[8];
        byte requestFrameTotalLength = 0x03;

        requestFrame[0] = requestFrameTotalLength;
        requestFrame[1] = serviceID;
        requestFrame[2] = udsRequest.subfunctionID;
        requestFrame[3] = udsRequest.statusBit;


        // Send the request frame
        diagCanTp.sendRequest(requestFrame, requestFrame.length);
        callbackMgr.Log(TAG, serviceName + " Sending request via ISO_15765tp: " + Arrays.toString(requestFrame));

        // Receive and handle the response frame from the server (ECU)
        serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
        if (response != serviceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return -1;
        }


        // Process the response
        callbackMgr.Log(TAG, serviceName + " Receiving data from ISO_15765tp: " + Arrays.toString(responseFrame));
        byte nrc = -1;

        switch (responseFrame[1]) {
            case POSITIVE_RESPONSE:
                callbackMgr.onDataAvailable(responseFrame, serviceID, udsRequest.statusBit,udsRequest.status);
                return 0;

            case NEGATIVE_RESPONSE:
                // Handle negative response
                nrc = responseFrame[2];
                String nrcDescription = UDSErrors.getErrorDescription(nrc);
                callbackMgr.onError(nrc, serviceName + "Negative Response Code: 0x" + Integer.toHexString(nrc) + " (" + nrcDescription + ")");
                break;
            default:
                // Handle other cases if needed
                break;
        }

        return 0;

    }


}
