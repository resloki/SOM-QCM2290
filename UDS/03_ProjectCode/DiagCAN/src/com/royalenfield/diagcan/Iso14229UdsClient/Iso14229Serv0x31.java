package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;




/**
 * This class implements a specific UDS diagnostic service with service ID 0x31,
 * which is used for Routine Control according to ISO 14229 standard.
 * This service allows performing actions related to memory management and checksums
 * on the ECU.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x31. It handles the following:
 *
 * - Building request frames for either erase memory or checksum calculation routines.
 * - Sending the request frame to the ECU.
 * - Receiving and processing the ECU's response, indicating success, failure, or timeout.
 * - Logging diagnostic information for debugging purposes.
 *
 * This class supports two specific routines:
 *
 * 1. **Erase Memory:** Erases a specified memory area on the ECU.
 * 2. **Checksum Calculation:** Calculates a checksum (CRC32) for a given program file.
 */
public class Iso14229Serv0x31 extends UdsDiagnosticService {
    private static final String TAG = Iso14229Serv0x31.class.getSimpleName();
    private static final byte POSITIVE_RESPONSE = 0x71;

    public static final short ERASE_MEMORY = (short) 0xFF00;
    public static final short CHECKSUM_CALCULATION = (short) 0xFF01;
    FirmwareProgramFile firmwareProgramFile = null;


    public Iso14229Serv0x31(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
        firmwareProgramFile = serviceInfo.firmwareProgramFile;
    }


    @Override
    byte[] buildRequestFrame() {
        byte[] requestFrame = null;

        switch (udsRequest.routineIdentifierValue) {
            case ERASE_MEMORY:
                requestFrame = new byte[5];
                requestFrame[0] = serviceID;
                requestFrame[1] = udsRequest.subfunctionID;
                requestFrame[2] = (byte) 0xff;
                requestFrame[3] = (byte) 0x00;
                requestFrame[4] = (byte) 0x00;
                break;
            case CHECKSUM_CALCULATION:
                long checksum = firmwareProgramFile.getCalculateCRC32();
                requestFrame = new byte[8];
                requestFrame[0] = serviceID;
                requestFrame[1] = udsRequest.subfunctionID;
                requestFrame[2] = (byte) 0xff;
                requestFrame[3] = (byte) 0x01;
                requestFrame[4] = (byte) ((checksum >> 24) & 0xFF);
                requestFrame[5] = (byte) ((checksum >> 16) & 0xFF);
                requestFrame[6] = (byte) ((checksum >> 8) & 0xFF);
                requestFrame[7] = (byte) (checksum & 0xFF);
                break;
            default:
                break;
        }
        return requestFrame;
    }


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


    private int eraseMemory(byte[] requestFrame) {

        Iso15765TransportIF.sendRequest(requestFrame, 5);

        // Receive and handle the response frame from the server (ECU)
        Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);
        if (Response.serviceResponse != ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackManager.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
             return buildResultCode(serviceID, (byte) FAILED, (byte) 0);
        }
        byte[] RxFrame = Response.getResponseFrame();

        return processResponse(RxFrame);
    }


    private int checksumCalculation(byte[] requestFrame) {

        Iso15765TransportIF.sendRequest(requestFrame, 8);

        // Receive and handle the response frame from the server (ECU)
        Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);
        if (Response.serviceResponse != ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS) {
            // Handle timeout if no response received within the specified time
            callbackManager.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
             return buildResultCode(serviceID, (byte) FAILED, (byte) 0);
        }


        byte[] RxFrame = Response.getResponseFrame();

        return processResponse(RxFrame);
    }


    @Override
    public int executeDiagnosticService() {
        int serviceStatus = -1;
        byte[] requestFrame = buildRequestFrame();

        switch (udsRequest.routineIdentifierValue) {
            case ERASE_MEMORY:
                serviceStatus = eraseMemory(requestFrame);
                if (0 == serviceStatus) {
                    callbackManager.log(TAG, "Service 0x31 Erase Memory successful");
                }
                break;
            case CHECKSUM_CALCULATION:
                serviceStatus = checksumCalculation(requestFrame);
                if (0 == serviceStatus) {
                    callbackManager.log(TAG, "Service 0x31 Checksum Calculation successful");
                }
                break;
            default:
                break;
        }

        return serviceStatus;
    }


}
