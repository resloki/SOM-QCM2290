package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.Map;


/**
 * This class implements a specific UDS diagnostic service with service ID 0x34,
 * which is used for Transfer Data according to ISO 14229 standard.
 * This service allows transferring a block of program data to the ECU for programming purposes.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 *
 * This class extends the {@link UdsDiagnosticService} class and overrides the abstract methods
 * to provide the specific implementation for service ID 0x34. It handles the following:
 *
 * 1. Building the request frame with program file information (start address and total length).
 * 2. Optionally including additional bytes in the request frame based on configuration.
 * 3. Sending the request frame to the ECU.
 * 4. Receiving and processing the ECU's response, indicating success (with maximum block length information), failure, or timeout.
 * 5. Logging diagnostic information for debugging purposes.
 *
 * This class relies on a separate `ProgramFile` object (likely part of `UdsComponents`)
 * to store program data and related information.
 */


public class Iso14229Serv0x34 extends UdsDiagnosticService {
    private static final String serviceName = "service Name: 0x34,";
    private static final byte POSITIVE_RESPONSE = 0x74;

    FirmwareProgramFile FirmwareProgramFile;

    public Iso14229Serv0x34(ServiceInfo serviceInfo, Iso15765TpInterface Iso15765TransportIF) {
         super(serviceInfo, Iso15765TransportIF);
        FirmwareProgramFile = serviceInfo.firmwareProgramFile;
    }

    /**
     * Builds the request frame with program file information.
     *
     * @return The constructed request frame.
     */
    @Override
    byte[] buildRequestFrame() {
        byte[] requestFrame = new byte[11];

        if (udsRequest.optionalBytesUsed) {
            // Handle optional bytes if present (potential utility method here)
            for (Map.Entry<Integer, Byte> entry : udsRequest.optionalBytes.entrySet()) {
                int index = entry.getKey();
                byte value = entry.getValue();

                if (index >= 0 && index < requestFrame.length) {
                    requestFrame[index] = value;
                }
            }
        }

        // Construct request buffer (specific to service 0x34)
        requestFrame[0] = serviceID;
        requestFrame[1] = 0x00;
        requestFrame[2] = 0x44;
        requestFrame[3] = (byte) ((FirmwareProgramFile.startAddress >> 24) & 0xFF);
        requestFrame[4] = (byte) ((FirmwareProgramFile.startAddress >> 16) & 0xFF);
        requestFrame[5] = (byte) ((FirmwareProgramFile.startAddress >> 8) & 0xFF);
        requestFrame[6] = (byte) (FirmwareProgramFile.startAddress & 0xFF);
        requestFrame[7] = (byte) ((FirmwareProgramFile.totalLength >> 24) & 0xFF);
        requestFrame[8] = (byte) ((FirmwareProgramFile.totalLength >> 16) & 0xFF);
        requestFrame[9] = (byte) ((FirmwareProgramFile.totalLength >> 8) & 0xFF);
        requestFrame[10] = (byte) (FirmwareProgramFile.totalLength & 0xFF);

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
                short maxOfBlockLength = (short) (((short) RxFrame[3] << 8) | (RxFrame[4]));
                FirmwareProgramFile.setMaxOfBlockLength(maxOfBlockLength);
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




    @Override
    public int executeDiagnosticService() {
        byte[] requestFrame = buildRequestFrame();
        Iso15765TransportIF.sendRequest(requestFrame, requestFrame.length);

        // Receive and handle the response frame from the server (ECU)
        Iso15765TransportIF.readResponse(Response, Iso15765TpInterface.responseTimeout);


        if (Response.serviceResponse != ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS) {
            // Handle timeout
            callbackManager.onCriticalFailure(RESPONSE_FAILED, processName +
                    "The operation timed out while awaiting the reception of Response frame from the BCM");
             return buildResultCode(serviceID, (byte) FAILED, (byte) 0);
        }
        byte[] RxFrame = Response.getResponseFrame();


        return processResponse(RxFrame);
    }


}

