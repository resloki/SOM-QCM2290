package com.royalenfield.uartservice;

public class FlexCAN_TMsgbuff_St_t {
    public int CANId;
    public byte IDE;
    public byte MessageType;
    public byte[] Data = new byte[8];
    public int DataLen;

}


