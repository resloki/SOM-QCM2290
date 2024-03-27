package com.royalenfield.diagcan.iso15765TP;

//communication interface layer configuration
public class I15765CanConfig {
    public static int physicalCanId = 0;
    public static int functionalCanId = 0;
    public static int responseCanId = 0;
    public final short CAN_TP_MAX_PAYLOAD_SIZE = 0xfff;
    public final short CAN_TP_DATA_SEGMENT_SIZE = 0x08;
    public final short CONSECUTIVE_FRAME_START_INDEX = 0x01;
    public static int timeoutMs = 0x1f4; //CAN TP Inter-Frame Space Time (500)
    public static byte TxSeperationTime = 0x05; //Receive Frames(sending flow control)

}
