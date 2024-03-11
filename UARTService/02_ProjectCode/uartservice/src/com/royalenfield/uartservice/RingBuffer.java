package com.royalenfield.uartservice;

import android.util.Log;

import java.util.Arrays;

public class RingBuffer {
    private char[] buffer;
    private int head = 0;
    private int tail = 0;
    private int bufferSize;
    private int count = 0;
    private static final String Sloki = "cantp";

    public RingBuffer(int size) {
        bufferSize = size;
        buffer = new char[size];
    }

    public void addData(char data) {
        if(count < bufferSize) {
            buffer[head] = data;
            head = (head + 1) % bufferSize;
            count++;
        } else {
            // Handle buffer overflow, maybe throw exception or overwrite old data
        }
    }


    public byte[] getData() {
        if(count >= 19) {
            byte[] dataFrame = new byte[19];
            for(int i = 0; i < 19; i++) {
                dataFrame[i] = (byte)buffer[tail];
                tail = (tail + 1) % bufferSize;
            }
            count -= 19;
            Log.d(Sloki,"Data in RingBuffer:"+ Arrays.toString(dataFrame));
            return dataFrame;
        } else {
            // Handle underflow, maybe throw exception
            return null;
        }
    }
}


