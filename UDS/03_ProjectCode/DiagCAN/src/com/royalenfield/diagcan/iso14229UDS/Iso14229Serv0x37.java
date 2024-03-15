package com.royalenfield.diagcan.iso14229UDS;


import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;
import java.util.Map;


public class Iso14229Serv0x37 extends DiagCanService {
    private static final String serviceName = "service Name: 0x37,";
    private static final byte POSITIVE_RESPONSE = 0x77;
    

    public Iso14229Serv0x37(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
    }


    @Override
    public int runService() {
        int result = -1;
        byte[] requestFrame = new byte[8];
        try {
            callbackMgr.Log(TAG, serviceName + "Initializing request buffer");

            if (udsRequest.optionalBytesUsed) {
                for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                    int index = entry.getKey();
                    byte value = entry.getValue();

                    if (index >= 0 && index < requestFrame.length) {
                        requestFrame[index] = value;
                    }
                }
            }


            callbackMgr.Log(TAG, serviceName + "Setting up request parameters");
            requestFrame[0] = 0x01;
            requestFrame[1] = serviceID;

            diagCanTp.sendRequest(requestFrame, requestFrame.length);
            callbackMgr.Log(TAG, serviceName + "Sending request via ISO_15765tp: " + Arrays.toString(requestFrame));


            // Receive and handle the response frame from the server (ECU)
            byte[] responseFrame = new byte[0];
            serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
            if (response != serviceResponse.RESPONSE_SUCCESS) {
                // Handle timeout if no response received within the specified time
                callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                        "The operation timed out while awaiting the reception of Response frame from the BCM");
                return -1;
            }


            if (udsRequest.SPR) {
                /* No response expected in Suppress Positive Response (SPR) mode */
                return 0;
            }


            callbackMgr.Log(TAG, serviceName + "receiving response via ISO_15765tp: " + Arrays.toString(responseFrame));


            switch (responseFrame[1]) {
                case POSITIVE_RESPONSE:
                    callbackMgr.Log(TAG, serviceName + "Positive Response: Request matches");
                    result = 0;
                    break;

                case NEGATIVE_RESPONSE:
                    // Handle negative response
                    result = responseFrame[3];
                    String nrcDescription = UDSErrors.getErrorDescription(responseFrame[3]);
                    callbackMgr.Log(TAG, serviceName + "Negative Response Code: 0x" + Integer.toHexString(responseFrame[3]) + " (" + nrcDescription + ")");
                    break;
            }

        } catch (Exception e) {
            // Handle InterruptedException if necessary
            e.printStackTrace();
        }
        return result;
    }


}



