package com.royalenfield.diagcan.iso15765TP.Transport;

import  com.royalenfield.diagcan.iso15765TP.session.Session;

/**
 * The TransportRx class represents the receiver side of the transport layer.
 * It implements the TransportComm interface for processing received transport layer data.
 * It delegates the received data to the session layer for further processing.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class TransportRx implements TransportComm{
    Session session;
    public TransportRx(Session session){
        this.session=session;
    }

    public void ProcessTLData_Rx(byte[] data, CANFrameType FrameType){

    }


    @Override
    public void processData(byte[] transportData,int length) {
        CANFrameType frameType = (length > 8) ? CANFrameType.SINGLE_FRAME : CANFrameType.MULTI_FRAME;
        session.ProcessRxData_Session(transportData);
    }
}
