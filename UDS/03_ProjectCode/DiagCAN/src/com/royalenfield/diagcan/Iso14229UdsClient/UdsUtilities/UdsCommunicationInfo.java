package com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class UdsCommunicationInfo {
    public String sessionName;
    public byte subfunctionID;
    public String status;
    public boolean SPR = false; //suppressPositiveResponse
    public boolean expectResponseData = false; //suppressPositiveResponse
    public int optionalBytesBufferLength;
    public boolean optionalBytesUsed;
    public String Requesting;
    public String SecurityLevel;
    public Map<Integer, Byte> optionalBytes = new HashMap<>();

    public short routineIdentifierValue;
    public short BlockSequenceCounter;
    public byte startAddressMemoryUpload ;
    public short lengthMemoryUpload;
    public DataIdentifierInfo dataIdentifierInfo;
    public Entry<Byte, String>  CommunicationType;
    public Entry<Byte, String>  IOCP;
    public DTCFormat DTCInfo;

}