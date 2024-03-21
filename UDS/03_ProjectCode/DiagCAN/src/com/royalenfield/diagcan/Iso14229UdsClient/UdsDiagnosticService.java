package com.royalenfield.diagcan.Iso14229UdsClient;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.UdsCommunicationInfo;
import  com.royalenfield.diagcan.UdsCallbackEventManager;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;


/**
 * This abstract class defines the core functionalities expected from diagnostic service implementations
 * in a Unified Diagnostic Service (UDS) tester project compliant with the ISO 14229 standard.
 * Subclasses should extend this class to implement specific diagnostic services used for interacting
 * with the Electronic Control Unit (ECU) over a CAN bus network.
 *
 * @author Venu Maniknoda
 */
public abstract class UdsDiagnosticService {

    abstract int executeDiagnosticService();
    abstract byte[] buildRequestFrame();
    abstract int processResponse(byte[] RxFrame);

    public static final byte SUCCESS = 0x00;
    public static final byte FAILED = (byte)0xFE;


    protected static final byte NEGATIVE_RESPONSE = 0x7F;
    protected static final byte SRP_FLAG = (byte) 0x80;

    protected final short RESPONSE_FAILED = 0xFF;

    UdsCallbackEventManager callbackManager = UdsCallbackEventManager.getInstance();
    ResponseFrameContainer Response = new ResponseFrameContainer();
    String TAG = "iso14229UDS";

    UdsDiagnosticService(ServiceInfo serviceInfo, Iso15765TpInterface udsInterface) {
        this.serviceName = serviceInfo.serviceName;
        this.serviceID = serviceInfo.udsRequest.SPR ? (byte) (SRP_FLAG | serviceInfo.serviceID) : (byte) serviceInfo.serviceID;
        this.processName = serviceInfo.processName;
        this.requestType = serviceInfo.requestType;
        this.udsRequest = serviceInfo.udsRequest;
        this.udsResponse = serviceInfo.udsResponse;
        this.gapTimeout = serviceInfo.gapTimeout;
        this.Iso15765TransportIF = udsInterface;
    }

    protected Iso15765TpInterface Iso15765TransportIF;
    protected String serviceName;
    protected byte serviceID;
    protected String processName;
    protected String requestType;
    protected UdsCommunicationInfo udsRequest;
    protected UdsCommunicationInfo udsResponse;
    protected int gapTimeout;


    protected int buildResultCode(byte serviceId, byte result, byte nrc) {
        // Construct the 32-bit result code
        return ((serviceId & 0xFF) << 24) | ((result & 0xFF) << 16) | (nrc & 0xFF);
    }



}
