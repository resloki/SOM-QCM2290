package com.royalenfield.diagcan.iso15765TP;

import com.royalenfield.diagcan.iso14229UDS.serviceResponse;

public interface DiagCanTp {
    int sendRequest(byte[] Payload, int payloadLength);
    serviceResponse readResponse(byte[] responseFrame, int timeoutInMillis);

}