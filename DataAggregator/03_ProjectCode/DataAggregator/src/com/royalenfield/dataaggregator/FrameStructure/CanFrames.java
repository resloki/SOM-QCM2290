package com.royalenfield.dataaggregator.FrameStructure;

/**
 * CanFrames represents a CAN frame structure containing information such as CAN ID, data, and data length.
 * - CANId: The identifier associated with the CAN frame.
 * - Data: An array of bytes containing the data of the CAN frame.
 * - DataLen: The length of the data contained in the CAN frame.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class CanFrames {
    public int CANId;

    public byte[] Data = new byte[8];
    public byte DataLen;
}
