package com.royalenfield.diagcan.iso15765TP;


public interface DataLinkConnectorTP {
    boolean transmitDataToDL(int canId, byte[] buff);
    void registerReceptionFromDL(RegisterCanTpCallbackDL callback);

}

