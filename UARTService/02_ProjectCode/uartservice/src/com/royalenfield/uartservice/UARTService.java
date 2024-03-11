package com.royalenfield.uartservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import com.royalenfield.uartservice.FrameStructureFormatter.FrameHandlingResult;
import com.royalenfield.uartservice.FrameStructureFormatter.FrameStructureFormatter;

import java.util.Arrays;
import com.royalenfield.uartservice.VcanCommunicationCallback;
import com.royalenfield.uartservice.VcanCommunicationInterface;

public class UARTService extends Service {
    // Initialize a RemoteCallbackList to manage callbacks from clients
    private final RemoteCallbackList<VcanCommunicationCallback> mCallbacks = new RemoteCallbackList<>();

    // Initialize a FrameStructureFormatter to format incoming frames and broadcast to other services(UDS and Data Aggrigator)
    private final FrameStructureFormatter mFrameFormatter = new FrameStructureFormatter();

    // Initialize a UART instance
    private UART mUart;

    // Flag to track UART connection status
    private boolean mIsUartConnected = false;

    // Tag for logging purposes
    private static final String TAG = "UART_Driver";

    // Create an instance of UartReceptionThread for handling UART reception
    UartReceptionThread receptionThread = new UartReceptionThread();

    Reception mReception = new Reception();


    /**
     * Implementation of the VcanCommunicationInterface Stub, providing methods for transmitting CAN data and registering a reception callback.
     * <p>
     * This Stub is responsible for handling communication between the client and server components of the VCAN service.
     */
    private final VcanCommunicationInterface.Stub mBinder = new VcanCommunicationInterface.Stub() {

        /**
         * Transmits CAN data to the UART for communication.
         *
         * @param canId   The CAN identifier.
         * @param payload The payload data to be transmitted.
         * @param length  The length of the payload.
         * @return Returns 0 if the transmission is successful, otherwise returns an error code.
         * @throws RemoteException Thrown if the communication with the remote service fails.
         */
        @Override
        public int vcanTransmitData(int canId, byte[] payload, byte length) throws RemoteException {
            FlexCAN_TMsgbuff_St_t canFrame = new FlexCAN_TMsgbuff_St_t();
            canFrame.CANId = canId;
            canFrame.Data = payload;

            canFrame.DataLen = length;
            return writeDataToUart(canFrame);
//            return 0; //TODO: venu, just for tesing... have to uncomment it
        }

        /**
         * Registers a callback for receiving data from the UART.
         *
         * @param callback The callback to be registered for receiving data.
         * @throws RemoteException Thrown if the communication with the remote service fails.
         */
        @Override
        public void registerReception(VcanCommunicationCallback callback) throws RemoteException {
            mCallbacks.register(callback);
            //TODO: venu, just for tesing... have to uncomment it
        }
    };


    /**
     * Called when the service is being bound to a client.
     *
     * @param intent The Intent that was used to bind to this service.
     * @return An IBinder through which clients can communicate with the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * Called by the system when the service is first created.
     * Initializes the UART connection.
     * Register the UART Reception callbcck
     * start the reception thread
     */
    @Override
    public void onCreate() {
        super.onCreate();
        initUART();

        receptionThread.connectUartReceptionCallback(mReception);
        receptionThread.start();//TODO: venu,just for tesing... have to uncomment it
    }


    /**
     * Initializes the UART connection.
     */
    private void initUART() {
        mUart = new UART();
//        int result = 0;
        int result = mUart.uartOpen(); // TODO: just for tesing...  Uncomment the line below to open the UART connection
        if (result != 0) {
            mIsUartConnected = true;
            Log.e(TAG, "Failed to open UART port");
        } else {
            Log.d(TAG, "UART port opened successfully");
        }
    }


    /**
     * Writes CAN message data to UART if the UART connection is established.
     *
     * @param canFrame The FlexCanMsgPkt object containing CAN message data to be written to UART.
     * @return 0 if the write operation was successful, otherwise returns the ordinal value of the FrameHandlingResult.
     */
    private int writeDataToUart(FlexCAN_TMsgbuff_St_t canFrame) {
        if (mReception.isConnected()) {
            try {
                byte[] txFrame = new byte[19];
                FrameHandlingResult result = mFrameFormatter.encodePacket(canFrame, txFrame);
                if (result != FrameHandlingResult.SUCCESS) {
                    return result.ordinal();
                }
                Log.d(TAG, "UARTWrite: " + Arrays.toString(txFrame));
                for (byte b : txFrame) {
                    Log.d(TAG, "UARTWrite typecast_Char: " + (char) b);
                    // TODO: just for tesing... Uncomment the line below to write the UART connection
                    mUart.uartWrite((char) b);
                }
            } catch (Exception e) {
                Log.e(TAG, "Error in UARTWrite", e);
                return -1;
            }
        }
        return 0;
    }


    class Reception implements UartReceptionThread.UartEventListener {
        /**
         * Checks if the UART connection is established and returns the connection status.
         *
         * @return true if the UART connection is established, false otherwise.
         */
        @Override
        public boolean isConnected() {
            return mIsUartConnected;
        }

        /**
         * Handles received data from UART by decoding it into a FlexCanMsgPkt object using the FrameStructureFormatter.
         * If decoding is successful, it broadcasts the received CAN message to registered callbacks.
         * If the UART connection is not established, the method does nothing.
         *
         * @param RMsgbuff The byte array containing the received data from UART.
         */
        @Override
        public void handleReceivedDataFromUart(byte[] RMsgbuff) {
            // Check if the UART connection is established
            if (isConnected()) {
                // Create a FlexCanMsgPkt object to store the decoded CAN message
                FlexCAN_TMsgbuff_St_t canFrame = new FlexCAN_TMsgbuff_St_t();

                // Decode the received data into the FlexCanMsgPkt object
                FrameHandlingResult status = mFrameFormatter.decodePacket(RMsgbuff, canFrame);

                // If decoding is successful, broadcast the received CAN message to registered callbacks
                if (status == FrameHandlingResult.SUCCESS) {
                    int numCallbacks = mCallbacks.beginBroadcast();
                    for (int i = 0; i < numCallbacks; i++) {
                        try {
                            mCallbacks.getBroadcastItem(i).onReceive(canFrame.CANId, canFrame.MessageType, canFrame.IDE, canFrame.Data, canFrame.DataLen);

                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    mCallbacks.finishBroadcast();
                }
            }
        }


        /**
         * Reads data from the UART JNI call.
         *
         * @return The character read from the UART, or '\0' if an error occurs.
         */
        @Override
        public char readDataFromUart() {
            try {
                // TODO: Uncomment the line below to read the UART connection
                return mUart.uartRead();
//                return '\0';
            } catch (Exception e) {
                Log.e(TAG, "Error in UARTRead: " + e.getMessage());
                return '\0';
            }
        }

    }


    /**
     * Called by the system when the service is no longer in use and is being destroyed.
     * Performs cleanup tasks, such as closing the UART connection.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mIsUartConnected = false;
        // TODO: just for tesing... Uncomment the line below to close the UART connection
        mUart.uartClose();
    }

}
