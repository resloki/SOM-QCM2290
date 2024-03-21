package com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader;

public class FirmwareProgramFile {
    public long totalLength;
    public long startAddress;
    public String programFilePath;
    public long calculateCRC32;
    protected short maxOfBlockLength = 0;

    protected short totalDataBlocks = 0;

    public FirmwareProgramFile(long totalLength, long startAddress, String programFilePath, long crcoutput) {
        this.totalLength = totalLength;
        this.startAddress = startAddress;
        this.programFilePath = programFilePath;
        this.calculateCRC32 = crcoutput;
    }

    public long getTotalLength() {
        return totalLength;
    }

    public long getStartAddress() {
        return startAddress;
    }

    public long getCalculateCRC32() {
        return calculateCRC32;
    }

    public void setCalculateCRC32(long calculateCRC32) {
        this.calculateCRC32 = calculateCRC32;
    }

    public String getProgramFilePath() {
        return programFilePath;
    }

    public short getMaxBlockSize() {
        return maxOfBlockLength;
    }

    public void setMaxOfBlockLength(short maxOfBlockLength) {
        this.maxOfBlockLength = maxOfBlockLength;
    }

}

