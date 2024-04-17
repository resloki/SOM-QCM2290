package com.royalenfield.DataAggregator;

/**
 * Interface for fetching vehicle data.
 * Implementations of this interface should provide a method to request data associated with a specific CANId.
 */
interface VehicleDataInterface {
    String[] requestCanid(String canId);
}