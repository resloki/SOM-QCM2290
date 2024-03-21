package com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities;

public class DTCFormat {

    private final byte formatID;
    private final byte mode;
    private final short mask;

    public DTCFormat(byte formatID, byte mode, short mask) {
        this.formatID = formatID;
        this.mode = mode;
        this.mask = mask;
    }

    public byte getFormatID() {
        return formatID;
    }

    public byte getMode() {
        return mode;
    }

    public short getMask() {
        return mask;
    }

    @Override
    public String toString() {
        return "DTCFormat{" +
                "formatID=" + String.format("%02X", formatID) +  // Format for hex with leading zeros
                ", mode=" + String.format("%02X", mode) +
                ", mask=" + String.format("%04X", mask) +   // Format for hex with leading zeros
                '}';
    }
}
