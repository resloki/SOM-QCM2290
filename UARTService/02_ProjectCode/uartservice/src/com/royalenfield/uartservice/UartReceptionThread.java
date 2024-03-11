package com.royalenfield.uartservice;

import android.util.Log;

public class UartReceptionThread extends Thread {


    /**
     * Connects a listener to receive UART data Reception callback.
     *
     * @param subscribeToUartReception The listener to receive UART data.
     */
    void connectUartReceptionCallback(UartEventListener subscribeToUartReception){
        this.UartConnection =subscribeToUartReception;
    }

    private final RingBuffer circularBuffer;
    private static final String TAG = "UART_Reception_Thread";
    private UartEventListener UartConnection;


    /**
     * isConnected A method to check the connection status.
     * handleReceivedDataFromUart A method to handle received data from UART.
     * readDataFromUart A method to read data from UART.
     */
    public interface UartEventListener {
        boolean isConnected();
        void handleReceivedDataFromUart(byte[] RMsgbuff);
        char readDataFromUart();
    }


    /**
     * Initializes a new instance of the UartReceptionThread class, creating a ring buffer with a capacity of 19 bytes to store the collected data received from UART.
     * This ring buffer will be used to buffer the incoming UART data before processing it further.
     */
    public UartReceptionThread() {
        this.circularBuffer = new RingBuffer(19);
    }




    /**
     * Runs the UART reception thread.
     */
    @Override
    public void run() {
        Log.e(TAG, "Started reading of CAN data...");
        while (UartConnection.isConnected()) {
            try {
                char dataByte = UartConnection.readDataFromUart();
                circularBuffer.addData(dataByte);
                byte[] readData = circularBuffer.getData();
                if (readData != null) {
                    UartConnection.handleReceivedDataFromUart(readData);
                }
            } catch (Exception e) {
                Log.e(TAG, "Exception found during UARTRead and processing: " + e);
            }
        }
    }







}
