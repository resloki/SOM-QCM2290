package com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents;


import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x10;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x11;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x14;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x19;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x22;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x27;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x28;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x2E;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x2F;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x31;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x34;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x35;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x36;
import  com.royalenfield.diagcan.Iso14229UdsClient.Iso14229Serv0x37;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsDiagnosticService;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.Iso14229UdsClient.iso14229_serv0x3E;
import  com.royalenfield.diagcan.UdsCallbackEventManager;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * This class implements the Factory Design Pattern to create instances of specific UDS diagnostic services
 * based on their service ID. It centralizes the logic for service object creation and decouples the client code
 * from knowing the concrete implementation details of each service class.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class Iso14229ServiceFactory implements UdsServiceFactory {
    private final String TAG = this.getClass().getSimpleName();
    Iso15765TpInterface Iso15765TransportIF;
    UdsCallbackEventManager callbackMgr = UdsCallbackEventManager.getInstance();
    FirmwareProgramFile FirmwareProgramFile;


    public UdsDiagnosticService createService(ServiceInfo serviceInfo) {

        byte serviceID = serviceInfo.serviceID;
        switch (serviceID) {
            case 0x3E:
                return new iso14229_serv0x3E(serviceInfo, Iso15765TransportIF);
            case 0x10:
                return new Iso14229Serv0x10(serviceInfo, Iso15765TransportIF);
            case 0x11:
                return new Iso14229Serv0x11(serviceInfo, Iso15765TransportIF);
            case 0x27:
                return new Iso14229Serv0x27(serviceInfo, Iso15765TransportIF);
            case 0x28:
                return new Iso14229Serv0x28(serviceInfo, Iso15765TransportIF);
            case 0x31:
                return new Iso14229Serv0x31(serviceInfo, Iso15765TransportIF);
            case 0x34:
                return new Iso14229Serv0x34(serviceInfo, Iso15765TransportIF);
            case 0x35:
                return new Iso14229Serv0x35(serviceInfo, Iso15765TransportIF);
            case 0x2E:
                return new Iso14229Serv0x2E(serviceInfo, Iso15765TransportIF);
            case 0x22:
                return new Iso14229Serv0x22(serviceInfo, Iso15765TransportIF);
            case 0x36:
                return new Iso14229Serv0x36(serviceInfo, Iso15765TransportIF);
            case 0x14:
                return new Iso14229Serv0x14(serviceInfo, Iso15765TransportIF);
            case 0x19:
                return new Iso14229Serv0x19(serviceInfo, Iso15765TransportIF);
            case 0x2F:
                return new Iso14229Serv0x2F(serviceInfo, Iso15765TransportIF);
            case 0x37:
                return new Iso14229Serv0x37(serviceInfo, Iso15765TransportIF);
            default:
                throw new IllegalArgumentException("Unsupported service ID: " + serviceInfo.serviceID);
        }
    }


    public List<UdsDiagnosticService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, FirmwareProgramFile firmwareProgramFile, Iso15765TpInterface Iso15765TransportIF) {
        try {
            this.Iso15765TransportIF = Iso15765TransportIF;
            this.FirmwareProgramFile = firmwareProgramFile;
            List<UdsDiagnosticService> udsServices = new ArrayList<>();
            callbackMgr.log(TAG,  "Starting Bootloader Service....");

            for (ServiceInfo service : serviceFIFO) {
                UdsDiagnosticService udsService = createService(service);
                if (udsService != null) {
                    udsServices.add(udsService);
                } else {
                    callbackMgr.log(TAG,  "service failed");
                    callbackMgr.log(TAG, "service failed: error in Template processing");
                    return null;
                }
            }
            return udsServices;

        } catch (Exception ex) {
            callbackMgr.log(TAG, "service failed: error in Template processing");
            return null;
        }
    }

    public List<UdsDiagnosticService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, Iso15765TpInterface Iso15765TransportIF) {
        try {
            this.Iso15765TransportIF = Iso15765TransportIF;
            List<UdsDiagnosticService> udsServices = new ArrayList<>();
            callbackMgr.log(TAG,  "Starting Application Service....");


            for (ServiceInfo service : serviceFIFO) {
                UdsDiagnosticService udsService = createService(service);
                if (udsService != null) {
                    udsServices.add(udsService);
                } else {
                    callbackMgr.log(TAG,  "service failed");
                    callbackMgr.log(TAG, "service failed: error in Template processing");
                    return null;
                }
            }
            return udsServices;

        } catch (Exception ex) {
            callbackMgr.log(TAG, "service failed: error in Template processing");
            return null;
        }
    }


}