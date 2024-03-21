package com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities;

public class ResponseFrameContainer {

    public enum ServiceResponse {

        RESPONSE_SUCCESS,
        RESPONSE_FAILD,
        NO_RESPONSE,

    }

    public ServiceResponse serviceResponse;

    private byte[] responseFrame;

    public ResponseFrameContainer() {
        this.responseFrame = null;
    }

    public byte[] getResponseFrame() {
        return responseFrame;
    }

    public void setResponseFrame(byte[] responseFrame) {
        this.responseFrame = responseFrame;
    }
}
