package com.royalenfield.dataaggregator.DataAggregator.FrameStructure;

public enum DataTransferStatus {
    SUCCESS,
    FAILED,
    UARTInitFailed,
    UARTTxSuccessful,
    UARTTxFailed,
    CommunicationEnds,
    BufferOverflow
}
