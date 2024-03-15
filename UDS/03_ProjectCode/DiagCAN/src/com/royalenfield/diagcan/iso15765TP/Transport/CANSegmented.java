package com.royalenfield.diagcan.iso15765TP.Transport;

public class CANSegmented {
    private CANFrameType MessageType;
    private byte[] SingleFrameData;
    private byte[][] MultiFrameFrameData;
    private byte sequence;

    public byte getsequence() {
        return sequence;
    }
    public void setsequence(byte sequence) {
        this.sequence=sequence;
    }
    public CANFrameType getType() {
        return MessageType;
    }
    public void setMessageType(CANFrameType MessageType) {
        this.MessageType= MessageType;
    }

    public byte[] getSingleFrameData() {
        return SingleFrameData;
    }

    public byte[][] getMultiFrameData() {
        return MultiFrameFrameData;
    }


    // Add a new field to keep track of the current frame index
    private int currentFrameIndex = 0;

    // Method to get the current frame index
    public int getCurrentFrameIndex() {
        return currentFrameIndex;
    }

    // Method to set the current frame index
    public void setCurrentFrameIndex(int index) {
        this.currentFrameIndex = index;
    }

    // Method to increment the current frame index
    public void incrementCurrentFrameIndex() {
        this.currentFrameIndex++;
    }

    public int setData(byte[] data) {
        this.SingleFrameData = data ;
        return 0;
    }


    public int setData(byte[][] data) {
        this.MultiFrameFrameData = data ;
        return 0;
    }

    public CANFrameType getMessageType(){
        return MessageType;
    }

    public byte[] getFirstFrameData() {
        return MultiFrameFrameData[0];
    }
}

