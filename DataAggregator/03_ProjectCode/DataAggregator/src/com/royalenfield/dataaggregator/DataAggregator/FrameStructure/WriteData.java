package com.royalenfield.dataaggregator.DataAggregator.FrameStructure;

public class WriteData implements FrameFormatterInterface {
    public DataTransferStatus transmit(int can_id, int messageType, byte[] payload, byte[] txFrame) {
        if (payload.length > 8) {
            return DataTransferStatus.BufferOverflow;
        }
        int sourceId = 0;

        byte[] payload_data = new byte[8];
        txFrame[0] = (byte) 0xA5; // Start of the frame
        txFrame[1] = (byte) 0xA5; // Start of the frame
        txFrame[2] = 0x0D; // FRAME LENGTH
        txFrame[3] = (byte) (((messageType << 4) & 0xF0) | (sourceId & 0x0F)); // source Id and message Type
        txFrame[4] = (byte) (can_id >> 24); // CAN ID
        txFrame[5] = (byte) (can_id >> 16); // CAN ID
        txFrame[6] = (byte) (can_id >> 8);  // CAN ID
        txFrame[7] = (byte) can_id;
        if (payload.length <= payload_data.length) {
            for (int j = 0; j < payload.length; j++) {
                payload_data[j] = payload[j];
            }
        }
        System.arraycopy(payload_data, 0, txFrame, 8, payload_data.length);

        txFrame[16] = CRCUtil.calculateCRC8(payload, payload.length);
        txFrame[17] = (byte) 0x5A; // end of frame
        txFrame[18] = (byte) 0x5A; // end of frame
        //sendpacket(txFrame);

        return DataTransferStatus.CommunicationEnds;
    }


    @Override
    public int write(byte[] buff, int canId, byte[] txFrame) {

        DataTransferStatus returnstatus = transmit(canId, 0, buff, txFrame);
        if (returnstatus == DataTransferStatus.BufferOverflow) {
            return -1;
        }
        return 0;
    }

    @Override
    public CanFrames Read(byte[] buff) {
        return null;
    }


}

