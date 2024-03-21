package com.royalenfield.diagcan.iso15765TP;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.iso15765TP.Network.Network;
import  com.royalenfield.diagcan.iso15765TP.Transport.Transport;
import  com.royalenfield.diagcan.iso15765TP.session.Session;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TpInterfaceManager extends Iso15765TpInterface {

    private Session Session;
    private Transport Transport;
    private Network Network;

    private final DataLinkConnectorTP connectDataLink;


    private final BlockingQueue<byte[]> receptionQueue = new ArrayBlockingQueue<>(1);


    void initializeLayers() {
        Session = new Session();
        Transport = new Transport();
        Network = new Network();


        Session.setSession(this::onDataReceived, Transport);
        Transport.SetTransport(Session, Network);
        Network.setNetwork(Transport, connectDataLink);


    }


    public void onDataReceived(byte[] data) {
        try {
            receptionQueue.put(data);
        } catch (InterruptedException e) {
            Log.e(TAG, "onDataReceived: Error:", e);
        }
    }


    public TpInterfaceManager(DataLinkConnectorTP connectDataLinkInterface) {
        this.connectDataLink = connectDataLinkInterface;
        initializeLayers();
    }

    public void setCanId(int physicalCanId, int functionalCanId, int responseCanId) {
        I15765CanConfig.physicalCanId = physicalCanId;
        I15765CanConfig.functionalCanId = functionalCanId;
        I15765CanConfig.responseCanId = responseCanId;
    }


    @Override
    public int sendRequest(byte[] Payload, int paloadLength) {
        Session.RecieveDataFromApplication(Payload, paloadLength);
        return 0;
    }

    @Override
    public void readResponse(ResponseFrameContainer Response, int timeoutInMillis) {
        try {
            byte[] responseFrame = receptionQueue.poll(timeoutInMillis, TimeUnit.MILLISECONDS);
            if (responseFrame != null) {
                Response.setResponseFrame(responseFrame);
                Response.serviceResponse = ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS;
                return;
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            Response.serviceResponse = ResponseFrameContainer.ServiceResponse.RESPONSE_FAILD;
        }
        Log.d("iso15765TP", "No data received within the timeout.");
        Response.serviceResponse = ResponseFrameContainer.ServiceResponse.NO_RESPONSE;
    }


}