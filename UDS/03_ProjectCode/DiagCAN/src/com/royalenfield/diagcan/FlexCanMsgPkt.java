package com.royalenfield.diagcan;

public class FlexCanMsgPkt {

    FlexCanMsgPkt() {
        Data = new byte[8];
    }

    public int CANId;
    public byte IDE;

    public byte[] Data;
    public int DataLen;
}