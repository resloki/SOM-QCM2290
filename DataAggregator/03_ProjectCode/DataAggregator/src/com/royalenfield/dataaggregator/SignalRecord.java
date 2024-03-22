package com.royalenfield.dataaggregator;

/**
 * SignalRecord class represents a single record of signal data retrieved from the database.
 * It encapsulates information such as timestamp, CAN ID, signal name, and data value.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class SignalRecord {
    private String timestamp;
    private String canId;
    private String signalName;
    private String data;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCanId() {
        return canId;
    }

    public void setCanId(String canId) {
        this.canId = canId;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}


