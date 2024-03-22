package com.royalenfield.diagcan.iso15765TP.Transport;

import  com.royalenfield.diagcan.iso15765TP.I15765CanConfig;
import  com.royalenfield.diagcan.iso15765TP.Network.Network;
import  com.royalenfield.diagcan.iso15765TP.session.Session;

/**
 * The Transport class represents the ISO 15765-2 transport layer.
 * It coordinates communication between the session layer and the network layer.
 * It initializes the transport communication channels for transmission and reception.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */

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
