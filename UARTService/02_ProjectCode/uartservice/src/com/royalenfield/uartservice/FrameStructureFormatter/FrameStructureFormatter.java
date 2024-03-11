package com.royalenfield.uartservice.FrameStructureFormatter;

import com.royalenfield.uartservice.FlexCAN_TMsgbuff_St_t;


/**
 * FrameFormatter: A utility class for encoding and decoding communication frames according to a specific protocol.
 * This class provides methods to encode CAN frames into a byte array and decode received byte arrays into CAN frames,
 * following the ICD communication frame format for BCM and SOM communication through UART.
 * ICD communication frame format:
 * - Start of Frame (SOF): 2 bytes (0xA5A5)
 * - Frame Length: 2 bytes (Length)
 * - Source ID: 1 byte (0x00 for SOM to BCM, 0x01 for BCM to SOM)
 * - Message Type: 1 byte (0x00 for Standard ID, 0x01 for Extended ID)
 * - CAN ID: 4 bytes (Can id)
 * - Payload: Data Record (Data bytes)
 * - Checksum: 1 byte (CRC8 - Checksum is calculated from 3rd byte onwards till payload bytes)
 * - End of Frame (EOF): 2 bytes (0x5A5A)
 * Note: the buffer size for transmission and reception is 19 bytes.
 */

public class FrameStructureFormatter {
    private static final short START_OF_FRAME = (short) 0xA5A5;
    private static final int FRAME_LENGTH = 0x0D;
    private static final short END_OF_FRAME = (short) 0x5A5A;
    private static final int PAYLOAD_OFFSET = 8;
    private static final int PAYLOAD_SIZE = 8;
    private static final int CRC_BYTE_INDEX = PAYLOAD_OFFSET + PAYLOAD_SIZE;

    public enum MessageType {
        STANDARD,
        EXTENDED
    }


    public FrameHandlingResult encodePacket(FlexCAN_TMsgbuff_St_t canFrame, byte[] txFrame) {
        if (canFrame.Data.length > PAYLOAD_SIZE) {
            return FrameHandlingResult.BUFFER_OVERFLOW;
        }

        int sourceId = canFrame.IDE;
        int messageType = canFrame.MessageType;
        int canId = canFrame.CANId;
        byte[] payload = canFrame.Data;

        if (txFrame.length < PAYLOAD_OFFSET + PAYLOAD_SIZE) {
            return FrameHandlingResult.BUFFER_OVERFLOW;
        }

        // Check for valid source ID
        if (sourceId != 0x00 && sourceId != 0x01) {
            return FrameHandlingResult.INVALID_SOURCE_ID;
        }

        txFrame[0] = (byte) (START_OF_FRAME >> 8); // Start of the frame (high byte)
        txFrame[1] = (byte) START_OF_FRAME;        // Start of the frame (low byte)
        txFrame[2] = (byte) FRAME_LENGTH;                  // Frame length
        txFrame[3] = (byte) (((messageType << 4) & 0xF0) | (sourceId & 0x0F)); // Source ID and Message Type
        txFrame[4] = (byte) (canId >> 24); // CAN ID (highest byte)
        txFrame[5] = (byte) (canId >> 16); // CAN ID
        txFrame[6] = (byte) (canId >> 8);  // CAN ID
        txFrame[7] = (byte) canId;         // CAN ID (lowest byte)

        System.arraycopy(payload, 0, txFrame, PAYLOAD_OFFSET, payload.length);

        // Calculate and set CRC
        txFrame[CRC_BYTE_INDEX] = CRCUtil.calculateCRC8(payload, payload.length);

        // Set end of frame
        txFrame[PAYLOAD_OFFSET + PAYLOAD_SIZE + 1] = (byte) (END_OF_FRAME >> 8); // End of the frame (high byte)
        txFrame[PAYLOAD_OFFSET + PAYLOAD_SIZE + 2] = (byte) END_OF_FRAME;     // End of the frame (low byte)

        return FrameHandlingResult.SUCCESS;
    }

    public FrameHandlingResult decodePacket(byte[] rxData, FlexCAN_TMsgbuff_St_t canFrame) {
        if (rxData.length < PAYLOAD_OFFSET + PAYLOAD_SIZE + 2) {
            return FrameHandlingResult.INCOMPLETE_FRAME;
        }

        short startOfFrame = (short) ((rxData[0] << 8) | (rxData[1] & 0xFF));
        if (startOfFrame != START_OF_FRAME) {
            return FrameHandlingResult.UNEXPECTED_START_OF_FRAME;
        }

        byte frameLength = rxData[2];
        if (frameLength != FRAME_LENGTH) {
            return FrameHandlingResult.INVALID_FRAME_LENGTH;
        }


        byte sourceId = (byte) (rxData[3] & 0x0F); // Extracting lower 4 bits for Source ID
        byte messageType = (byte) ((rxData[3] >> 4) & 0x0F); // Extracting upper 4 bits for Message Type
        if (messageType >= MessageType.values().length) {
            return FrameHandlingResult.UNSUPPORTED_MESSAGE_TYPE;
        }
        canFrame.IDE = sourceId;
        canFrame.MessageType = messageType;

        int canId;
        if (messageType == 0) {
            canId = ((rxData[3] << 24) | ((rxData[4] & 0xFF) << 16) | ((rxData[5] & 0xFF) << 8) | (rxData[6] & 0xFF));
        } else {
            canId = ((rxData[3] << 8) | (rxData[4] & 0xFF));
        }
        canFrame.CANId = canId;

        byte[] payload = new byte[PAYLOAD_SIZE];
        System.arraycopy(rxData, PAYLOAD_OFFSET, payload, 0, PAYLOAD_SIZE);
        canFrame.Data = payload;

        byte calculatedCRC = CRCUtil.calculateCRC8(payload, PAYLOAD_SIZE);
        if (calculatedCRC != rxData[CRC_BYTE_INDEX]) {
            return FrameHandlingResult.CHECKSUM_ERROR;
        }

        short endOfFrame = (short) ((rxData[17] << 8) | (rxData[18] & 0xFF));
        if (endOfFrame != END_OF_FRAME) {
            return FrameHandlingResult.UNEXPECTED_END_OF_FRAME;
        }

        return FrameHandlingResult.SUCCESS;
    }


}
