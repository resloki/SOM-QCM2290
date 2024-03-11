package com.royalenfield.uartservice.FrameStructureFormatter;

public enum  FrameHandlingResult {
    SUCCESS,
    INCOMPLETE_FRAME,
    INVALID_FRAME_LENGTH,
    CHECKSUM_ERROR,
    BUFFER_OVERFLOW,
    UNEXPECTED_END_OF_FRAME,
    UNEXPECTED_START_OF_FRAME,
    UNSUPPORTED_MESSAGE_TYPE,
    INVALID_SOURCE_ID,
}
