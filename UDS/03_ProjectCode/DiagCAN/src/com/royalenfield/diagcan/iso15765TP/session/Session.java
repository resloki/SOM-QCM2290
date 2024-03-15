package com.royalenfield.diagcan.iso15765TP.session;

import com.royalenfield.diagcan.iso15765TP.I15765CanConfig;
import com.royalenfield.diagcan.iso15765TP.Transport.Transport;

import java.util.function.Consumer;

public class Session extends I15765CanConfig {
    Transport Transport;
    boolean SessionInit;
    private Consumer<byte[]> onDataReceivedCallback;

    public Session() {

    }


    public void setSession(Consumer<byte[]> callback, Transport Transport) {

        this.Transport = Transport;

        this.onDataReceivedCallback = callback;
        SessionInit = true;
    }


    public void RecieveDataFromApplication(byte[] data, int dataLength) {
        if (SessionInit) {

            Transport.transportTx.processData(data, dataLength);
        }
    }

    public void ProcessRxData_Session(byte[] data) {
        onDataReceivedCallback.accept(data);
    }

}
