package com.royalenfield.dataaggregator.CanIDConfig;


/**
 * The CanIDManager class is responsible for managing Controller Area Network (CAN) message identifiers (IDs)
 * for various time intervals. It provides arrays for storing CAN IDs categorized based on their transmission
 * frequency, including messages sent every 10ms, 50ms, and 500ms. These arrays are public and final,
 * allowing read-only access to the CAN IDs they contain. This class serves as a central repository for
 * organizing and accessing CAN IDs used within the system, facilitating efficient management and
 * configuration of CAN communications.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class CanIDManager {

    public final byte[] CanID_10ms = new byte[]{
            (byte) 0x232, (byte) 0x12E, (byte) 0x12A, (byte) 0x152, (byte) 0x155
    };
    public final byte[] CanID_50ms = new byte[]{
            (byte) 0x6BA, (byte) 0x6BB
    };
    public final byte[] CanID_500ms = new byte[]{
            (byte) 0x647, (byte) 0x648, (byte) 0x649, (byte) 0x64A, (byte) 0x641,
            (byte) 0x642, (byte) 0x631, (byte) 0x632, (byte) 0x644, (byte) 0x645,
            (byte) 0x666, (byte) 0x667, (byte) 0x668, (byte) 0x669, (byte) 0x643,
            (byte) 0x646, (byte) 0x157, (byte) 0x70F, (byte) 0x16F, (byte) 0x170,
            (byte) 0x41E, (byte) 0x41F, (byte) 0x650, (byte) 0x64F, (byte) 0x371,
            (byte) 0x361, (byte) 0xA07, (byte) 0x321, (byte) 0x121, (byte) 0x231,
            (byte) 0x341, (byte) 0x62B, (byte) 0x64B, (byte) 0x65B, (byte) 0x169,
            (byte) 0x680, (byte) 0x151, (byte) 0x12F, (byte) 0x221, (byte) 0x50E,
            (byte) 0x19F, (byte) 0x50F, (byte) 0x1A7, (byte) 0x1B3, (byte) 0x1B4,
            (byte) 0x1B5, (byte) 0x1B6, (byte) 0x1B7, (byte) 0x1B8, (byte) 0x1B9,
            (byte) 0x14E, (byte) 0x16E, (byte) 0x172, (byte) 0x17E, (byte) 0x153,
            (byte) 0x154, (byte) 0x171, (byte) 0x174, (byte) 0x4CE, (byte) 0x173,
            (byte) 0x555, (byte) 0x16F
    };

}
