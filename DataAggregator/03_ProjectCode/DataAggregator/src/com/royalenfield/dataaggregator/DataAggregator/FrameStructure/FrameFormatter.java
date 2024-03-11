package com.royalenfield.dataaggregator.DataAggregator.FrameStructure;

import android.util.Log;

import java.util.Arrays;

public class FrameFormatter {
    private static final int FRAME_LENGTH = 19;
    public FrameFormatterInterface Transmission;
    public FrameFormatterInterface Reception;


    public FrameFormatter() {
        Transmission = new WriteData();
        Reception = new ReadData();
    }


    public byte[] encodePacket(byte[] byteArray, int canId) {
        byte[] txFrame = new byte[19];
        int result = Transmission.write(byteArray, canId, txFrame);
        if (result == 0) {

            return txFrame;
        }
        return null;
    }

    public CanFrames decodePacket(byte[] byteArray) {
        return Reception.Read(byteArray);
    }






    public ProcessedData processReceivedData(byte[] data) {
        if (data.length == FRAME_LENGTH && data[0] == (byte) 0xA5 && data[1] == (byte) 0xA5
                && data[17] == (byte) 0x5A && data[18] == (byte) 0x5A) {

            // Valid frame received, you can now process the data
            byte calculatedCRC = CRCUtil.calculateCRC8(data, 16);

            // Verify CRC
            if (calculatedCRC == data[16]) {
                // CRC is valid, return payload and CAN ID
                int canId = ((data[4] & 0xFF) << 24) | ((data[5] & 0xFF) << 16) | ((data[6] & 0xFF) << 8) | (data[7] & 0xFF);
                byte[] payload = Arrays.copyOfRange(data, 8, 16);

                // You can now dispatch the payload and CAN ID or perform further processing
                return new ProcessedData(canId, payload);
            } else {
                Log.e("UartService", "CRC check failed. Discarding the frame.");
            }
        } else {
            Log.e("UartService", "Invalid frame received. Discarding the frame.");
        }
        return null;
    }

}







