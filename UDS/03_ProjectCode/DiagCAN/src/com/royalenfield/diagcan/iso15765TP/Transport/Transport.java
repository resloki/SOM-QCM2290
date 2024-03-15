package com.royalenfield.diagcan.iso15765TP.Transport;

import com.royalenfield.diagcan.iso15765TP.I15765CanConfig;
import com.royalenfield.diagcan.iso15765TP.Network.Network;
import com.royalenfield.diagcan.iso15765TP.session.Session;


public class Transport extends I15765CanConfig {

    Session session;
    Network network;

    public TransportComm transportTx;
    public TransportComm transportRx;

    public void SetTransport(Session session, Network network) {
        this.session=session;
        this.network=network;
        transportTx = new transportTx(network);
        transportRx = new TransportRx(session);
    }

}
