package com.royalenfield.diagcan.iso15765TP.Transport;

import  com.royalenfield.diagcan.iso15765TP.I15765CanConfig;
import  com.royalenfield.diagcan.iso15765TP.Network.Network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class transportTx extends I15765CanConfig implements TransportComm {
    Network network;
    private ExecutorService executorService;

    transportTx(Network network) {
        executorService = Executors.newSingleThreadExecutor();
        this.network = network;
    }


    @Override
    public void processData(byte[] transportData, int length) {
        CANSegmented TPData = new CANSegmented();
        if (CAN_TP_MAX_PAYLOAD_SIZE >= transportData.length) {
            if (CAN_TP_DATA_SEGMENT_SIZE > length) {
                byte[] dataWithPadding = new byte[CAN_TP_DATA_SEGMENT_SIZE];
                System.arraycopy(transportData, 0, dataWithPadding, 1, length);
                dataWithPadding[0] = (byte) length;
                TPData.setMessageType(CANFrameType.SINGLE_FRAME);
                TPData.setData(dataWithPadding);
                submitNetworkProcessing(TPData);
            } else {
                TPData.setMessageType(CANFrameType.MULTI_FRAME);
                byte[][] MultiSegmentedData = DataSegmentation(transportData, length);
                TPData.setData(MultiSegmentedData);
                submitNetworkProcessing(TPData);
            }
        }
    }


    private void submitNetworkProcessing(CANSegmented TPData) {
        network.TxReceivedFromTransport(TPData);
//        executorService.submit(() -> {
//            network.TxReceivedFromTransport(TPData);
//        });
    }


    public byte[][] DataSegmentation(byte[] RecFromSession, int length) {
        int totalMessageLength = length;
        byte[] firstFrame = FirstFrame(RecFromSession, totalMessageLength);

        int numberOfFullFrames = (totalMessageLength - 6) / 7;
        int remainingFrameSize = (totalMessageLength - 6) % 7;
        // Calculate total number of frames
        int totalFrames = numberOfFullFrames + (remainingFrameSize > 0 ? 1 : 0) + 1;
        // Initialize the array of frames
        byte[][] frames = new byte[totalFrames][8];
        frames[0] = firstFrame; // Set the first frame

        int messageIndex = 6; // Index in the RecFromSession
        byte sequenceNumber = 0; // Sequence number for CFs

        for (int i = 1; i < totalFrames; i++) {
            // Set the frame type nibble
            byte frameTypeNibble = (byte) (CANFrameType.CONSECUTIVE_FRAME.ordinal() << 4);
            // Properly increment and wrap the sequence number
            sequenceNumber = (byte) ((sequenceNumber + 1) & 0x0F); // Increment and wrap the sequence number
            // No need to shift frameTypeNibble again as it's already in the higher nibble
            frames[i][0] = (byte) (frameTypeNibble | sequenceNumber); // Combine frame type and sequence number

            // Determine the size of the frame and copy the data
            int frameSize = Math.min(7, totalMessageLength - messageIndex);
            System.arraycopy(RecFromSession, messageIndex, frames[i], 1, frameSize);
            messageIndex += frameSize;
        }

        // Return the segmented frames
        return frames;
    }


//    public byte[][] DataSegmentation(byte[] RecFromSession) {
//        int totalMessageLength = RecFromSession.length;
//        byte[] firstFrame = FirstFrame(RecFromSession, totalMessageLength);
//
//        int numberOfFullFrames = (totalMessageLength - 6) / 7;
//        int remainingFrameSize = (totalMessageLength - 6) % 7;
//        // Calculate total number of frames
//        int totalFrames = numberOfFullFrames + (remainingFrameSize > 0 ? 1 : 0) + 1;
//        // Initialize the array of frames
//        byte[][] frames = new byte[totalFrames][8];
//        frames[0] = firstFrame; // Set the first frame
//
//        int messageIndex = 6; // Index in the RecFromSession
//        byte sequenceNumber = 0; // Sequence number for CFs
//
//        for (int i = 1; i < totalFrames; i++) {
//            // Set the frame type nibble
//            byte frameTypeNibble = (byte) (CANFrameType.CONSECUTIVE_FRAME.ordinal() << 4);
//            // Properly increment and wrap the sequence number
//            sequenceNumber = (byte) ((sequenceNumber + 1) & 0x0F); // Increment and wrap the sequence number
//            // No need to shift frameTypeNibble again as it's already in the higher nibble
//            frames[i][0] = (byte) (frameTypeNibble | sequenceNumber); // Combine frame type and sequence number
//
//            // Determine the size of the frame and copy the data
//            int frameSize = Math.min(7, totalMessageLength - messageIndex);
//            System.arraycopy(RecFromSession, messageIndex, frames[i], 1, frameSize);
//            messageIndex += frameSize;
//        }
//
//        // Return the segmented frames
//        return frames;
//    }


    byte[] FirstFrame(byte[] Source_data, int totalMessageLength) {

        byte upperNibble = (byte) ((totalMessageLength >> 8) & 0x0F); // Extract the upper 4 bits of the length.
        byte lowerNibble = (byte) (totalMessageLength & 0xFF); // Extract the lower 8 bits of the length.

        byte[] Destination_frameData = new byte[8];
        Destination_frameData[0] = (byte) ((CANFrameType.FIRST_FRAME.ordinal() << 4) | upperNibble);
        Destination_frameData[1] = lowerNibble; // Set the lower nibble.

        System.arraycopy(Source_data, 0, Destination_frameData, 2, 6); // Copy the data starting from byte 2.
        return Destination_frameData;
    }


}
