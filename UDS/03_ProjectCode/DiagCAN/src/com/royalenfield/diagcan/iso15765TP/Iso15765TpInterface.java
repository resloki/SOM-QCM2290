package com.royalenfield.diagcan.iso15765TP;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;

public abstract class Iso15765TpInterface {

    public static short responseTimeout = 5000;
    public abstract int sendRequest(byte[] Payload, int payloadLength);
    public abstract void readResponse(ResponseFrameContainer Response, int timeoutInMillis);

}