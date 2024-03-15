package com.royalenfield.diagcan.iso14229UDS;

import android.util.Log;

import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;
import java.util.Map;


public class Iso14229Serv0x27 extends DiagCanService {
    private static final String serviceName = "service Name: 0x27,";
    private static final byte POSITIVE_RESPONSE = 0x67;

    private final byte[] secret_key = new byte[]{'A', 'A', 'A', 'A', 'B', '3', 'N', 'z', 'a', 'C', '1', 'y', 'c', '2', 'E', 'A', 'A', 'A', 'A', 'D', 'A', 'Q', 'A', 'B', 'A', 'A', 'A', 'B', 'A', 'Q', 'C', 'a'}; //todo hridhya


    public Iso14229Serv0x27(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
    }


    @Override
    public int runService() {
        byte nrc = -1;
        try {
            byte[] requestFrame = new byte[8];

            // Fill in optional bytes if applicable
            if (udsRequest.optionalBytesUsed) {
                for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                    int index = entry.getKey();
                    byte value = entry.getValue();

                    if (index >= 0 && index < requestFrame.length) {
                        requestFrame[index] = value;
                    }
                }
            }


            requestFrame[0] = 0x02;
            requestFrame[1] = serviceID;
            requestFrame[2] = 0x01;

            // Send request via ISO 15765 TP
            diagCanTp.sendRequest(requestFrame, requestFrame.length);
            callbackMgr.Log(TAG, serviceName + "Request Seed(0x01) sent to server: " + Arrays.toString(requestFrame));

            // Receive and handle the response frame from the server (ECU)
            byte[] responseFrame = new byte[0];
            serviceResponse response;
            response = diagCanTp.readResponse(responseFrame, responseTimeout);
            if (response != serviceResponse.RESPONSE_SUCCESS) {
                // Handle timeout if no response received within the specified time
                callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                        "The operation timed out while awaiting the reception of Response frame from the BCM");
                return -1;
            }


            // Extract seed from reception buffer
            byte[] seed = new byte[16];
            System.arraycopy(responseFrame, 2, seed, 0, seed.length);

            // Generate key from seed
            byte[] Key = new byte[16];
            AES128.AES128_ECB_encrypt(seed, secret_key, Key);

            // Construct request frame format for sending key
            byte[] requestFrameFormatforSendKey = new byte[18];
            requestFrameFormatforSendKey[0] = 0x27;
            requestFrameFormatforSendKey[1] = 0x02;
            System.arraycopy(Key, 0, requestFrameFormatforSendKey, 2, Key.length);

            // Send request for sending key
            diagCanTp.sendRequest(requestFrameFormatforSendKey, requestFrameFormatforSendKey.length);
            callbackMgr.Log(TAG, serviceName + "Request for Send Key(0x02) sent to server: " + Arrays.toString(requestFrameFormatforSendKey));

            // Receive response
            response = diagCanTp.readResponse(responseFrame, responseTimeout);
            if (response != serviceResponse.RESPONSE_SUCCESS) {
                // Handle timeout if no response received within the specified time
                callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                        "The operation timed out while awaiting the reception of Response frame from the BCM");
                return -1;
            }

            callbackMgr.Log(TAG, serviceName + " Receiving response: " + Arrays.toString(responseFrame));

            // Process response
            if (responseFrame != null) {
                switch (responseFrame[1]) {
                    case POSITIVE_RESPONSE:
                        // Check if the first three bytes match the expected pattern
                        if (responseFrame.length >= 3 && responseFrame[0] == 0x02 && responseFrame[2] == 0x02) {
                            callbackMgr.Log(TAG, serviceName + "Positive Response: Expected pattern matched");
                            return 0;
                        }
                        break;

                    case NEGATIVE_RESPONSE:
                        // Handle negative response
                        nrc = responseFrame[2];
                        String nrcDescription = UDSErrors.getErrorDescription(nrc);
                        callbackMgr.Log(TAG, serviceName + "Negative Response Code: 0x" + Integer.toHexString(nrc) + " (" + nrcDescription + ")");
                        break;

                    default:
                        // Handle other cases if needed
                        break;
                }
            } else {
                callbackMgr.onCriticalFailure(RESPONSE_FAILED, serviceName + "The operation timed out while awaiting the reception of Response frame from the BCM");
            }
            return nrc;
        } catch (Exception e) {
            Log.e(TAG, serviceName + " Exception occurred: " + e.getMessage());
            return nrc;
        }
    }


}
