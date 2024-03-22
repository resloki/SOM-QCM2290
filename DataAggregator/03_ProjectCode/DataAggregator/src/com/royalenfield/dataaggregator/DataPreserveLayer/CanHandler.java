package com.royalenfield.dataaggregator.DataPreserveLayer;

import com.royalenfield.dataaggregator.FrameStructure.CanFrames;

/**
 * Functional interface for handling CAN frames.
 * Implementations of this interface define how to process received CAN frames.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
@FunctionalInterface
public interface CanHandler {
    void handleCanData(CanFrames receivedData, Intervals interval);
}
