package com.royalenfield.diagcan.iso14229UDS;

import java.util.HashMap;
import java.util.Map;

public class UdsCommunicationInfo {
    public String sessionName;
    public byte subfunctionID;
    public byte statusBit;
    public String status;
    public boolean SPR = false; //suppressPositiveResponse
    public int optionalBytesBufferLength;
    public boolean optionalBytesUsed;
    public String Requesting;
    public String SecurityLevel;
    public Map<Integer, Byte> optionalBytes = new HashMap<>();
    public byte IOCP; //Input and output control parameter
    public short routineIdentifierValue;
    public short BlockSequenceCounter;
    public byte startAddressMemoryUpload ;
    public short lengthMemoryUpload;
    public DataIdentifierInfo dataIdentifierInfo;
    public byte communicationType;
    public String communicationName;

}