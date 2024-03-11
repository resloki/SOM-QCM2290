package com.royalenfield.dataaggregator.DataAggregator.FrameStructure;

public class ProcessedData {
    private int canId;
    private byte[] payload;

    public ProcessedData(int canId, byte[] payload) {
        this.canId = canId;
        this.payload = payload;
    }

    public int getCanId() {
        return canId;
    }

    public byte[] getPayload() {
        return payload;
    }
}
