package com.royalenfield.diagcan.iso15765TP.Network;


import  com.royalenfield.diagcan.FlexCanMsgPkt;
import  com.royalenfield.diagcan.iso15765TP.DataLinkConnectorTP;
import  com.royalenfield.diagcan.iso15765TP.I15765CanConfig;
import  com.royalenfield.diagcan.iso15765TP.RegisterCanTpCallbackDL;
import  com.royalenfield.diagcan.iso15765TP.Transport.CANFrameType;
import  com.royalenfield.diagcan.iso15765TP.Transport.CANSegmented;
import  com.royalenfield.diagcan.iso15765TP.Transport.Transport;

/**
 * The Network class represents the ISO 15765-2 Network layer.
 * It acts as an interface between the Transport layer and the Data Link layer.
 * This class handles the transmission and reception of segmented CAN frames.
 * It processes data received from the Data Link layer and forwards it to the appropriate layer for further processing.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class Network  extends  I15765CanConfig implements RegisterCanTpCallbackDL {
    private static Transport transport;
    private DataLinkConnectorTP connectDataLink;
    private static NetwrokLayerRx networkLayerRx;
    private static NetworkLayerTx networkLayerTx;
    private static final String TAG = "DiagCanServiceMain";


    public void setNetwork(Transport transport, DataLinkConnectorTP connectDataLink) {
        this.transport = transport;
        this.connectDataLink = connectDataLink;
        networkLayerRx = new NetwrokLayerRx(Network.transport, connectDataLink);
        networkLayerTx = new NetworkLayerTx(Network.transport, connectDataLink);
        connectDataLink.registerReceptionFromDL(this);
    }

    public void TxReceivedFromTransport(CANSegmented segments) {
        try {
            if (segments.getMessageType() == CANFrameType.SINGLE_FRAME) {
                byte[] databytes = segments.getSingleFrameData();
                connectDataLink.transmitDataToDL(physicalCanId, databytes);
            } else if (segments.getMessageType() == CANFrameType.MULTI_FRAME) {
                networkLayerTx.processMultiFrameTxData(segments);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void processDataLinkResponse(byte[] Payload) throws InterruptedException {
        CANFrameType frameType = CANFrameType.values()[(Payload[0] >> 4) & 0x0F];

        switch (frameType) {
            case SINGLE_FRAME:
                transport.transportRx.processData(Payload, Payload.length);
                break;
            case FIRST_FRAME:
                networkLayerRx.rxProcessRxFirstFrame(Payload);
                break;
            case CONSECUTIVE_FRAME:
                networkLayerRx.processRxConsecutiveFrame(Payload);
                break;
            case FLOW_CONTROL:
                networkLayerTx.handleFlowControlFrame(Payload);
                break;
            default:
                break;
        }
    }


    /**
     * Receives data from the Data Link layer (UARTService).
     * Processes the received data if the source ID indicates it is from BCM to SOM.
     *
     * @param canMsg The FlexCanMsgPkt containing the data to be received from the Network layer.
     */
    @Override
    public void sendDataToNetworkLayer(FlexCanMsgPkt canMsg) {
        try {
            if (canMsg.DataLen == 0x08 &&
                    canMsg.IDE == 0x01 &&
                    canMsg.CANId == responseCanId) {
                processDataLinkResponse(canMsg.Data);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
