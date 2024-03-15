package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.io.BufferedInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class Iso14229Serv0x36 extends DiagCanService {
    private static final String serviceName = "service Name: 0x36,";

    private static final byte POSITIVE_RESPONSEFrame = 0x76;

    private byte currentblock = 0x00;


    public ProgramFile ProgramFile;


    public Iso14229Serv0x36(ServiceInfo serviceInfo, DiagCanTp CANtp) {
        super(serviceInfo, CANtp);
        ProgramFile = serviceInfo.ProgramFile;
    }

    @Override
    public int runService() {
        boolean transferStatus = false;
        int result = -1;
        short maxOfBlockLength = ProgramFile.getMaxOfBlockLength();
        byte[] requestFrame = new byte[maxOfBlockLength];
        short totalDataBlocks = 0;
        if (udsRequest.optionalBytesUsed) {
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                int index = entry.getKey();
                byte value = entry.getValue();

                if (index >= 0 && index < requestFrame.length) {
                    requestFrame[index] = value;
                }
            }
        }


        int totalBytes = 0;
        int totalBlocks = 0;
        byte sequenceCounter = 1;

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(ProgramFile.programFilePath)))) {
            totalBytes = bufferedInputStream.available();
            totalBlocks = (totalBytes + requestFrame.length - 1) / requestFrame.length;
            totalDataBlocks = (short) totalBlocks;
            callbackMgr.Log(TAG, serviceName + "totalBlocks: " + totalBlocks);

            byte[] responseFrame = new byte[0];



            while (sequenceCounter <= totalBlocks) {
                requestFrame[0] = 0x36;
                requestFrame[1] = sequenceCounter;

                int bytesRead = bufferedInputStream.read(requestFrame, 2, requestFrame.length - 2);
                if (bytesRead == -1) {
                    callbackMgr.Log(TAG, serviceName + "Reached end of file");
                    break;
                }

                diagCanTp.sendRequest(requestFrame, bytesRead + 2);
                currentblock = sequenceCounter;

                // Receive and handle the response frame from the server (ECU)
                serviceResponse response = diagCanTp.readResponse(responseFrame, responseTimeout);
                if (response != serviceResponse.RESPONSE_SUCCESS) {
                    // Handle timeout if no response received within the specified time
                    callbackMgr.onCriticalFailure(RESPONSE_FAILED, processName +
                            "The operation timed out while awaiting the reception of Response frame from the BCM");
                    return -1;
                }



                /*Handling Negative response*/
                if (responseFrame == null || responseFrame.length < 2 || responseFrame[1] != POSITIVE_RESPONSEFrame) {
                    transferStatus = false;
                    if (responseFrame == null) {
                        callbackMgr.Log(TAG, serviceName + "Incorrect Message Length or Invalid Format");
                    } else {
                        result = handleNegativeResponse(responseFrame);
                    }
                    break;
                }

                callbackMgr.Log(TAG, serviceName + "currentBlock: " + sequenceCounter);
                callbackMgr.progressUpdate(sequenceCounter * maxOfBlockLength);

                Thread.sleep(1);
                sequenceCounter++;
            }

            // Set transferStatus to true if all blocks were successfully transferred
            transferStatus = (sequenceCounter > totalBlocks);
            if (transferStatus) {
                result = 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return result;
        } finally {
            printTransferStatus(transferStatus);
        }

        return result;
    }

    private int handleNegativeResponse(byte[] responseFrame) {
        byte negativeResponseCode = -1;
        callbackMgr.Log("iso14229UDS", serviceName + "Negative Response received:");
        if (responseFrame.length >= 3) {
            negativeResponseCode = responseFrame[2];
            String nrcDescription = UDSErrors.getErrorDescription(negativeResponseCode);
            callbackMgr.Log(TAG, serviceName + "Negative Response Code: 0x" + Integer.toHexString(negativeResponseCode) + " (" + nrcDescription + ")");
        }
        return negativeResponseCode;
    }


    private void printTransferStatus(boolean transferStatus) {
        callbackMgr.Log(TAG, serviceName + (transferStatus ? "Positive Response: Request successful" : "Negative Response: Request unsuccessful"));
    }


}



