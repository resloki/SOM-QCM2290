package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;
import java.util.Map;

public class Iso14229Serv0x34 extends DiagCanService {
    private static final String serviceName = "service Name: 0x34,";
    private static final byte POSITIVE_RESPONSE = 0x74;

    ProgramFile ProgramFile;

    public Iso14229Serv0x34(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
        ProgramFile = serviceInfo.ProgramFile;
    }


    @Override
    public int runService() {
        byte[] requestFrame = new byte[11];

        if (udsRequest.optionalBytesUsed) {
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                int index = entry.getKey();
                byte value = entry.getValue();

                if (index >= 0 && index < requestFrame.length) {
                    requestFrame[index] = value;
                }
            }
        }


        callbackMgr.Log(TAG, serviceName + "Optional bytes filled+");

        // Construct request buffer
        requestFrame[0] = serviceID;
        requestFrame[1] = 0x00;
        requestFrame[2] = 0x44;
        requestFrame[3] = (byte) ((ProgramFile.startAddress >> 24) & 0xFF);
        requestFrame[4] = (byte) ((ProgramFile.startAddress >> 16) & 0xFF);
        requestFrame[5] = (byte) ((ProgramFile.startAddress >> 8) & 0xFF);
        requestFrame[6] = (byte) (ProgramFile.startAddress & 0xFF);
        requestFrame[7] = (byte) ((ProgramFile.totalLength >> 24) & 0xFF);
        requestFrame[8] = (byte) ((ProgramFile.totalLength >> 16) & 0xFF);
        requestFrame[9] = (byte) ((ProgramFile.totalLength >> 8) & 0xFF);
        requestFrame[10] = (byte) (ProgramFile.totalLength & 0xFF);
        callbackMgr.Log(TAG, serviceName + "Request buffer constructed");

        // Send request via ISO 15765 TP
        int length = 0x0B;
        diagCanTp.sendRequest(requestFrame, length);
        callbackMgr.Log(TAG, serviceName + "Request sent via ISO_15765tp: " + Arrays.toString(requestFrame));

        // Receive and handle the response frame from the server (ECU)
        byte[] responseFrame = new byte[0];
        serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
        if (response != serviceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return -1;
        }


        callbackMgr.Log(TAG, serviceName + "Response received: " + Arrays.toString(responseFrame));


        // Process response
        byte nrc = -1;

        switch (responseFrame[1]) {
            case POSITIVE_RESPONSE:
                short maxOfBlockLength = (short) (((short) responseFrame[3] << 8) | (responseFrame[4]));
                ProgramFile.setMaxOfBlockLength(maxOfBlockLength);
                callbackMgr.Log(TAG, serviceName + "Positive Response: Request successful");
                return 0;

            case NEGATIVE_RESPONSE:
                // Handle negative response
                nrc = responseFrame[2];
                String nrcDescription = UDSErrors.getErrorDescription(nrc);
                callbackMgr.Log(TAG, serviceName + "(Request Download) Negative Response Code: 0x" + Integer.toHexString(nrc) + " (" + nrcDescription + ")");
                break;

            default:
                // Handle other cases if needed
                break;
        }

        return nrc;
    }


}

