package com.royalenfield.uartservice;

// Import the callback interface
import com.royalenfield.uartservice.VcanCommunicationCallback;

// Declare the interface
interface VcanCommunicationInterface {
    // Define the method
    int vcanConnect(int Buadrate);
    void vcanDisconnect();
    int vcanTransmitData(in int canId, in byte[] payload, byte length);
    void registerReception(VcanCommunicationCallback callback);
    void unregisterReception(VcanCommunicationCallback callback);
}
