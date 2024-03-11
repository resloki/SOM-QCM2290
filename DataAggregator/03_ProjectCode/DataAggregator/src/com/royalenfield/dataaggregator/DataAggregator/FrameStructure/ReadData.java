package com.royalenfield.dataaggregator.DataAggregator.FrameStructure;

import android.util.Log;

import java.util.Arrays;

public class ReadData implements FrameFormatterInterface {

    private static final String TAG="ReadData";
    private static final short START_OF_FRAME = (short) 0xA5A5;
    private static final short END_OF_FRAME = 0x5A5A;
    private static final int PAYLOAD_SIZE = 8;

    @Override
    public int write(byte[] buff, int canId, byte[] txFrame) {
        return 0;
    }

    @Override
    public CanFrames Read(byte[] buff) {
        Log.d(TAG, "buffer in ProcessVCANData:" + Arrays.toString(buff));
        try {
            if (buff.length != 19) {
                Log.e(TAG, "Error: Buffer size must be 19 bytes");
                throw new IllegalArgumentException("Buffer size must be 19 bytes");
            }
            Log.d(TAG, "buffer Length is equal to 19");

            CanFrames FlexCAN_TMsgbuff_St = new CanFrames();
            short frameStart = (short) ((buff[0] << 8) + (buff[1] & 0xFF));
            if (frameStart != START_OF_FRAME) {
                Log.e(TAG, "Error: Invalid start of frame");
                throw new IllegalArgumentException("Invalid start of frame");
            }

            //Can ID
            FlexCAN_TMsgbuff_St.CANId= (((int) buff[4] << 24) | ((int) buff[5] << 16)
                    | ((int) buff[6] << 8) | (buff[7] & 0xFF));

            //Data Length
            FlexCAN_TMsgbuff_St.DataLen = PAYLOAD_SIZE;

            // Extracting the payload
            System.arraycopy(buff, 8, FlexCAN_TMsgbuff_St.Data, 0, PAYLOAD_SIZE);

            // Checksum and end of frame handling
            byte calculatedCRC = CRCUtil.calculateCRC8(FlexCAN_TMsgbuff_St.Data, FlexCAN_TMsgbuff_St.Data.length);
            if (calculatedCRC != buff[16]) {
                Log.e(TAG, "Error: Checksum mismatch");
                throw new IllegalArgumentException("Checksum mismatch");
            }
            Log.d(TAG, "buffer Length is equal to calculatedCRC");

            short frameEnd = (short) ((buff[17] << 8) + (buff[18] & 0xFF));
            if (frameEnd != END_OF_FRAME) {
                Log.e(TAG, "Error: Invalid end of frame");
                throw new IllegalArgumentException("Invalid end of frame");
            }

            // Log successful processing
            Log.e(TAG, "VCAN Data processed successfully");

            return FlexCAN_TMsgbuff_St;
        } catch (IllegalArgumentException e) {
            // Here you can handle the exception as needed
            Log.e(TAG, "Exception occurred: " + e.getMessage());
        }
        return null;
    }

}
