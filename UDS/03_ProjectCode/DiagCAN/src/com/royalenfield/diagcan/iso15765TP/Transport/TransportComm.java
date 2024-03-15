package com.royalenfield.diagcan.iso15765TP.Transport;

public interface TransportComm {
    void processData(byte[] transportData, int length);
}
