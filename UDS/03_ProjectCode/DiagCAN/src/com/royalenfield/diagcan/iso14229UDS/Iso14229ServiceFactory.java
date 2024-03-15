package com.royalenfield.diagcan.iso14229UDS;


import com.royalenfield.diagcan.UdsCallbackEventManager;
import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Iso14229ServiceFactory implements UdsServiceFactory {
    private final String TAG = this.getClass().getSimpleName();

    DiagCanTp CANtp;

    UdsCallbackEventManager callbackMgr = UdsCallbackEventManager.getInstance();
    ProgramFile ProgramFile;


    public DiagCanService createService(ServiceInfo serviceInfo) throws Exception {

        byte serviceID = serviceInfo.serviceID;
        switch (serviceID) {
            case 0x3E:
                return new iso14229_serv0x3E(serviceInfo, CANtp);
            case 0x10:
                return new Iso14229Serv0x10(serviceInfo, CANtp);
            case 0x11:
                return new Iso14229Serv0x11(serviceInfo, CANtp);
            case 0x27:
                return new Iso14229Serv0x27(serviceInfo, CANtp);
            case 0x28:
                return new Iso14229Serv0x28(serviceInfo, CANtp);
            case 0x31:
                return new Iso14229Serv0x31(serviceInfo, CANtp);
            case 0x34:
                return new Iso14229Serv0x34(serviceInfo, CANtp);
            case 0x2E:
                return new Iso14229Serv0x2E(serviceInfo, CANtp);
            case 0x22:
                return new Iso14229Serv0x22(serviceInfo, CANtp);
            case 0x36:
                return new Iso14229Serv0x36(serviceInfo, CANtp);
            case 0x14:
                return new Iso14229Serv0x14(serviceInfo, CANtp);
            case 0x19:
                return new Iso14229Serv0x19(serviceInfo, CANtp);
            case 0x2F:
                return new Iso14229Serv0x2F(serviceInfo, CANtp);
            case 0x37:
                return new Iso14229Serv0x37(serviceInfo, CANtp);
            default:
                throw new IllegalArgumentException("Unsupported service ID: " + serviceInfo.serviceID);
        }
    }


    public List<DiagCanService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, ProgramFile programFile, DiagCanTp CANtp) {
        try {
            this.CANtp = CANtp;
            this.ProgramFile = programFile;
            List<DiagCanService> udsServices = new ArrayList<>();
            String methodName = "createServiceInstances";
            callbackMgr.Log(TAG, methodName + "Starting Bootloader Service....");

            for (ServiceInfo service : serviceFIFO) {
                DiagCanService udsService = createService(service);
                if (udsService != null) {
                    udsServices.add(udsService);
                } else {
                    callbackMgr.Log(TAG, methodName + "service failed");
                    callbackMgr.Log(TAG, "service failed: error in Template processing");
                    return null;
                }
            }
            return udsServices;

        } catch (Exception ex) {
            callbackMgr.Log(TAG, "service failed: error in Template processing");
            return null;
        }
    }

    public List<DiagCanService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, DiagCanTp CANtp) {
        try {
            this.CANtp = CANtp;
            List<DiagCanService> udsServices = new ArrayList<>();
            String methodName = "createServiceInstances";
            callbackMgr.Log(TAG, methodName + "Starting Application Service....");


            for (ServiceInfo service : serviceFIFO) {
                DiagCanService udsService = createService(service);
                if (udsService != null) {
                    udsServices.add(udsService);
                } else {
                    callbackMgr.Log(TAG, methodName + "service failed");
                    callbackMgr.Log(TAG, "service failed: error in Template processing");
                    return null;
                }
            }
            return udsServices;

        } catch (Exception ex) {
            callbackMgr.Log(TAG, "service failed: error in Template processing");
            return null;
        }
    }


}