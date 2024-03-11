package com.royalenfield.dataaggregator.DataAggregator.FrameStructure;

public interface FrameFormatterInterface {
    int write(byte[] buff, int canId,byte[] txFrame);
    CanFrames Read(byte[] buff);
}
