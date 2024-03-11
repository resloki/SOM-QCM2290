package com.royalenfield.dataaggregator.DataAggregator.DataPreserveLayer;


import com.royalenfield.dataaggregator.DataAggregator.FrameStructure.CanFrames;

/**
 * Functional interface defining a method to handle CAN frames with associated intervals.
 */

@FunctionalInterface
public interface CanHandler {
    void handle(CanFrames receivedData, Intervals interval);
}
