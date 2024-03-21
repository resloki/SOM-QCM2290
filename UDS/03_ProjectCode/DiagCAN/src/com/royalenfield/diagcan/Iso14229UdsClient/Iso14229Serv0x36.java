package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer.ServiceResponse;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.io.BufferedInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class implements a specific UDS diagnostic service with service ID 0x36,
 * which is used for Transfer Data (Block) according to ISO 14229 standard.
 * This service allows transferring a program file data block by block to the ECU for programming purposes.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x36. It handles the following:
 *
 * 1. Building the request frame with a sequence counter (initialized to 1).
 * 2. Reading data blocks from a program file using a `BufferedInputStream`.
 * 3. Sending each data block to the ECU using the ISO 15765 transport layer.
 * 4. Receiving and processing the ECU's response for each block, indicating success or failure (NRC).
 * 5. Handling timeouts during communication.
 * 6. Tracking the transferred block count and total file size for progress reporting.
 * 7. Logging diagnostic information for debugging purposes.
 *
 * This class relies on a separate `ProgramFile` object (likely part of `UdsComponents`)
 * to store program data, file path, and block size information.
 */
public class Iso14229Serv0x36 extends UdsDiagnosticService {
    private static final byte POSITIVE_RESPONSE = 0x76;
    public FirmwareProgramFile firmwareProgramFile;
    int resultCode = -1;
    short maxOfBlockLength = 0;

    public Iso14229Serv0x36(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
        firmwareProgramFile = serviceInfo.firmwareProgramFile;
    }


    @Override
    byte[] buildRequestFrame() {
        byte[] requestFrame = new byte[maxOfBlockLength];
        requestFrame[0] = 0x36;
        return requestFrame;
    }

    @Override
    int processResponse(byte[] RxFrame) {

        if (Response.serviceResponse != ServiceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackManager.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
            return  buildResultCode(serviceID, NEGATIVE_RESPONSE, RxFrame[2]);
        }


        if (RxFrame == null || RxFrame.length < 2 || RxFrame[1] != POSITIVE_RESPONSE) {
            if (RxFrame == null) {
                callbackManager.log(TAG, serviceName + "Incorrect Message Length or Invalid Format");
            } else {
                return  buildResultCode(serviceID, NEGATIVE_RESPONSE, RxFrame[2]);
            }

        }
        return SUCCESS;
    }


    @Override
    public int executeDiagnosticService() {
        boolean transferStatus;
        maxOfBlockLength = firmwareProgramFile.getMaxBlockSize();
        byte[] requestFrame = null;
        boolean transferFailed = false;

        int totalBytes;
        int totalBlocks;
        byte sequenceCounter = 1;


        int resultCode = -1;
        byte nrc;


        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(firmwareProgramFile.getProgramFilePath())))) {
            totalBytes = bufferedInputStream.available();
            totalBlocks = (totalBytes + maxOfBlockLength - 1) / maxOfBlockLength;
            callbackManager.log(TAG, serviceName + "totalBlocks: " + totalBlocks);


            while (sequenceCounter <= totalBlocks) {

                requestFrame = buildRequestFrame();
                requestFrame[1] = sequenceCounter;
                int bytesRead = bufferedInputStream.read(requestFrame, 2, maxOfBlockLength - 2);
                if (bytesRead == -1) {
                    callbackManager.log(TAG, serviceName + "Reached end of file");
                    transferFailed = true;
                    break;
                }

                Iso15765TransportIF.sendRequest(requestFrame, bytesRead + 2);


                Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);


                /*Handling Negative response*/
                if (0 != processResponse(Response.getResponseFrame())) {
                    transferFailed = true;
                    break;
                }
                callbackManager.log(TAG, serviceName + "currentBlock: " + sequenceCounter);
                callbackManager.progressUpdate(totalBytes, sequenceCounter * maxOfBlockLength);

                Thread.sleep(1);
                sequenceCounter++;
            }

            // Set transferStatus to true if all blocks were successfully transferred
            if (!transferFailed) {
                transferStatus = (sequenceCounter > totalBlocks);
                if (transferStatus) {
                     resultCode = buildResultCode(serviceID, SUCCESS, (byte) 0);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            resultCode = buildResultCode(serviceID, (byte) FAILED, (byte) 0xfe);
        }

        return resultCode;
    }


}




