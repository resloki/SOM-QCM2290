package com.royalenfield.diagcan.iso14229UDS;

import java.util.List;

public class DataIdentifierInfo {
    public short number;
    public String name;
    public boolean dataRecordUsed;
    public byte bufferLength;
    public List<Byte> byteValues;

    public DataIdentifierInfo(short number,
                              String name,
                              boolean dataRecordUsed,
                              byte bufferLength,
                              List<Byte> byteValues) {
        this.number = number;
        this.name = name;
        this.dataRecordUsed = dataRecordUsed;
        this.bufferLength = bufferLength;
        this.byteValues = byteValues;
    }

    @Override
    public String toString() {
        return "DataIdentifierInfo{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", dataRecordUsed=" + dataRecordUsed +
                ", bufferLength=" + bufferLength +
                ", byteValues=" + byteValues +
                '}';
    }
}

