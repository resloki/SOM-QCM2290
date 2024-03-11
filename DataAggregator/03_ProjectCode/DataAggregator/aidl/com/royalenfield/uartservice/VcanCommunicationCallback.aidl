package com.royalenfield.uartservice;

// Define the callback interface
interface VcanCommunicationCallback {
    void onReceive(int CANId, in byte[] Data, in byte length);
}
