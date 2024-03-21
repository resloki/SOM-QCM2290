package com.royalenfield.diagcan.Iso14229UdsClient;


import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.AES128;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.Map;

/**
 * This class implements a specific UDS diagnostic service with service ID 0x27,
 * which is used for Security Access according to ISO 14229 standard.
 * This service allows establishing a secure session with the ECU using a challenge-response mechanism
 * with AES128 encryption.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x27. It handles the following steps:
 *
 * 1. Sends a request for a seed (subfunction 0x01) to the ECU.
 * 2. Receives the seed from the ECU's response.
 * 3. Generates a session key using a pre-configured secret key and the received seed with AES128 encryption.
 * 4. Sends a request to send the generated key (subfunction 0x02) to the ECU.
 * 5. Receives the ECU's response indicating success or failure.
 *
 * This class uses a placeholder for the secret key (`secret_key`) that should be replaced with
 * an actual secret key value for secure communication.
 */
public class Iso14229Serv0x27 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x27,";
    private static final byte POSITIVE_RESPONSE = 0x67;
    private final byte[] secret_key = new byte[]{
            'A', 'A', 'A', 'A', 'B', '3', 'N',
            'z', 'a', 'C', '1', 'y', 'c', '2',
            'E', 'A', 'A', 'A', 'A', 'D', 'A',
            'Q', 'A', 'B', 'A', 'A', 'A', 'B',
            'A', 'Q', 'C', 'a'}; //todo hridhya


    public Iso14229Serv0x27(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
    }

    @Override
    byte[] buildRequestFrame() {
        short requestFrameTotalLength;

        if (udsRequest.optionalBytesUsed) {
            // Calculate total length including optional bytes
            requestFrameTotalLength = (short) (2 + udsRequest.optionalBytes.size());
            byte[] requestFrame = new byte[requestFrameTotalLength];

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
            return new byte[]{serviceID, 0x01};
        }
    }


    @Override
    int processResponse(byte[] RxFrame) {
        int resultCode = -1;

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
                resultCode = buildResultCode(serviceID, NEGATIVE_RESPONSE, RxFrame[2]);
                break;
            default:
                // Handle other cases if needed
                break;
        }
        return resultCode;
    }


    private byte[] buildSendKeyFrame(byte[] seed) {
        byte[] requestFrame = new byte[18];
        requestFrame[0] = serviceID;
        requestFrame[1] = 0x02; // Send key request
        System.arraycopy(seed, 0, requestFrame, 2, seed.length);
        return requestFrame;
    }


    @Override
    public int executeDiagnosticService() {
        /**
         * Sends a request for a seed (subfunction 0x01) to the server (ECU).
         */
        byte[] seedRequestFrame = buildRequestFrame();
        Iso15765TransportIF.sendRequest(seedRequestFrame, seedRequestFrame.length);

        /**
         * Reads the response frame from the server (ECU) and checks for success.
         */
        Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);
        if (Response.serviceResponse != ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS) {
            // Handle timeout
            return buildResultCode(serviceID, FAILED, (byte) 0xFF);
        }
        byte[] RxFrame = Response.getResponseFrame();

        /**
         * Extracts the seed bytes from the received response frame.
         */
        byte[] seed = new byte[16];
        System.arraycopy(RxFrame, 2, seed, 0, seed.length);

        /**
         * Generates a key using the AES128 encryption algorithm with the secret key and extracted seed.
         */
        byte[] Key = new byte[16];
        AES128.AES128_ECB_encrypt(seed, secret_key, Key);

        /**
         * Sends a request to send the generated key (subfunction 0x02) to the server (ECU).
         */
        byte[] sendKeyRequestFrame = buildSendKeyFrame(Key);
        Iso15765TransportIF.sendRequest(sendKeyRequestFrame, sendKeyRequestFrame.length);

        /**
         * Reads the response frame from the server (ECU) and checks for success.
         */
        Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);
        if (Response.serviceResponse != ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS) {
            // Handle timeout
            return buildResultCode(serviceID, FAILED, (byte) 0xFF);
        }
        RxFrame = Response.getResponseFrame();

        return processResponse(RxFrame);
    }


}
