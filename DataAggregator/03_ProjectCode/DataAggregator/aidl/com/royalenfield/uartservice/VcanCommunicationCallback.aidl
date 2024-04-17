package com.royalenfield.uartservice;

// Define the callback interface
interface VcanCommunicationCallback {
    void onReceive(int CANId,  byte MessageType, byte IDE,in byte[] Data,int DataLen);
}