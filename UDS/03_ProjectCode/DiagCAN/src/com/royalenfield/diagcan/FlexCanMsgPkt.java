package com.royalenfield.diagcan;

public class FlexCanMsgPkt {
     public int CANId;
     public byte IDE;
    public byte[] Data = new byte[8];
    public int DataLen;
}