package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.UdsCallbackEventManager;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;


public abstract class DiagCanService {

    abstract int runService();

    protected static final byte NEGATIVE_RESPONSE = 0x7F;
    protected static final byte SRP_FLAG = (byte) 0x80;

    UDSNrcCodes UDSErrors = new UDSNrcCodes();
    protected final short responseTimeout = 5000;
    protected final short RESPONSE_FAILED = 0xFF;

    UdsCallbackEventManager callbackMgr = UdsCallbackEventManager.getInstance();

    String TAG = "iso14229UDS";

    DiagCanService(ServiceInfo serviceInfo, DiagCanTp I15765tp) {
        this.serviceName = serviceInfo.serviceName;
        this.serviceID = udsRequest.SPR ? (byte) (SRP_FLAG | serviceInfo.serviceID) : (byte) serviceInfo.serviceID;
        this.processName = serviceInfo.processName;
        this.requestType = serviceInfo.requestType;
        this.udsRequest = serviceInfo.udsRequest;
        this.udsResponse = serviceInfo.udsResponse;
        this.gapTimeout = serviceInfo.gapTimeout;
        this.diagCanTp = I15765tp;
    }

    protected DiagCanTp diagCanTp;
    protected String serviceName;
    protected byte serviceID;
    protected String processName;
    protected String requestType;
    protected UdsCommunicationInfo udsRequest;
    protected UdsCommunicationInfo udsResponse;
    protected int gapTimeout;


}
