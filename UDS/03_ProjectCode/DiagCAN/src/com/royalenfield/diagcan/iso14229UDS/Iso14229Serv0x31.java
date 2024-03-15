package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.Arrays;
import java.util.Map;

public class Iso14229Serv0x31 extends DiagCanService {
    private static final String TAG = Iso14229Serv0x31.class.getSimpleName();
    private static final byte POSITIVE_RESPONSE = 0x71;

    public static final short ERASE_MEMORY = (short) 0xFF00;
    public static final short CHECKSUM_CALCULATION = (short) 0xFF01;

    ProgramFile programFile = null;

    public void setProgramFile(ProgramFile programFile) {
        this.programFile = programFile;
    }

    public Iso14229Serv0x31(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
        programFile = serviceInfo.ProgramFile;
    }

    @Override
    public int runService() {
        int serviceStatus = -1;
        byte[] requestFrame = new byte[8];

        if (udsRequest.optionalBytesUsed) {
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                int index = entry.getKey();
                byte value = entry.getValue();

                if (index >= 0 && index < requestFrame.length) {
                    requestFrame[index] = value;
                }
            }
        }


        switch (udsRequest.routineIdentifierValue) {
            case ERASE_MEMORY:
                serviceStatus = eraseMemory(requestFrame);
                if (0 == serviceStatus) {
                    callbackMgr.Log(TAG, "Service 0x31 Erase Memory successful");
                }
                break;
            case CHECKSUM_CALCULATION:
                serviceStatus = checksumCalculation();
                if (0 == serviceStatus) {
                    callbackMgr.Log(TAG, "Service 0x31 Checksum Calculation successful");
                }
                break;
            default:
                break;
        }

        return serviceStatus;
    }


    private int handleNegativeResponse(byte[] responseFrame) {
        callbackMgr.Log(TAG, "Service 0x31 Negative Response received:");
        byte negativeResponseCode = -1;
        if (responseFrame.length >= 3) {
            negativeResponseCode = responseFrame[3];
            String nrcDescription = UDSErrors.getErrorDescription(negativeResponseCode);
            callbackMgr.Log(TAG, "Service 0x31 " + nrcDescription + ", Negative Response Code: 0x" + Integer.toHexString(negativeResponseCode & 0xFF));
        }
        return negativeResponseCode;
    }

    private int eraseMemory(byte[] requestFrame) {
        int serviceStatus = -1;


        requestFrame[0] = 0x05;
        requestFrame[1] = serviceID;
        requestFrame[2] = udsRequest.subfunctionID;
        requestFrame[3] = (byte) 0xff;
        requestFrame[4] = (byte) 0x00;
        requestFrame[5] = (byte) 0x00;

        diagCanTp.sendRequest(requestFrame, requestFrame.length);
        callbackMgr.Log(TAG, "Service 0x31 Sending Erase Memory request: " + Arrays.toString(requestFrame));

        // Receive and handle the response frame from the server (ECU)
        byte[] responseFrame = new byte[0];
        serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
        if (response != serviceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return -1;
        }



        if (responseFrame != null) {
            callbackMgr.Log(TAG, "Service 0x31 Receiving Erase Memory response: " + Arrays.toString(responseFrame));

            byte responseByte = responseFrame[1];

            switch (responseByte) {
                case POSITIVE_RESPONSE:
                    callbackMgr.Log(TAG, "Service 0x31 Erase Memory successful");
                    return 0;
                case NEGATIVE_RESPONSE:
                    serviceStatus = handleNegativeResponse(responseFrame);
                    break;
                default:
                    callbackMgr.Log(TAG, "Service 0x31 Invalid Response: Erase Memory failed");
                    break;
            }
        } else {
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, serviceName + "The operation timed out while awaiting the reception of Response frame from the BCM");
        }

        return serviceStatus;
    }

    private int checksumCalculation() {
        int serviceStatus = -1;

        long checksum = programFile.getCalculateCRC32();
        byte[] requestFrame = new byte[9];
        int length = 0;
        requestFrame[0] = serviceID;
        requestFrame[1] = udsRequest.subfunctionID;
        requestFrame[2] = (byte) 0xff;
        requestFrame[3] = (byte) 0x01;
        requestFrame[4] = (byte) ((checksum >> 24) & 0xFF);
        requestFrame[5] = (byte) ((checksum >> 16) & 0xFF);
        requestFrame[6] = (byte) ((checksum >> 8) & 0xFF);
        requestFrame[7] = (byte) (checksum & 0xFF);
        length = 8;

        diagCanTp.sendRequest(requestFrame, length);
        callbackMgr.Log(TAG, "Service 0x31 Sending Checksum Calculation request: " + Arrays.toString(requestFrame));



        byte[] responseFrame = new byte[0];
        serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
        if (response != serviceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return -1;
        }

        if (responseFrame != null) {
            callbackMgr.Log(TAG, "Service 0x31 Receiving Checksum Calculation response: " + Arrays.toString(responseFrame));

            byte responseByte = responseFrame[1];
            callbackMgr.Log(TAG, "Service 0x31 Checksum Calculation Response: " + responseByte);
            switch (responseByte) {
                case POSITIVE_RESPONSE:
                    callbackMgr.Log(TAG, "Service 0x31 Positive Response: Checksum Calculation");
                    return 0;
                case NEGATIVE_RESPONSE:
                    serviceStatus = handleNegativeResponse(responseFrame);
                    break;
                default:
                    callbackMgr.Log(TAG, "Service 0x31 Invalid Response: Checksum Calculation failed");
                    break;
            }
        } else {
            callbackMgr.onCriticalFailure(RESPONSE_FAILED, serviceName + "The operation timed out while awaiting the reception of Response frame from the BCM");
        }

        return serviceStatus;
    }


}
