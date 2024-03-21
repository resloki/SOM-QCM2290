package com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents;

import com.royalenfield.diagcan.Iso14229UdsClient.UdsDiagnosticService;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.util.List;
import java.util.Queue;

public interface UdsServiceFactory {
    List<UdsDiagnosticService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, FirmwareProgramFile firmwareProgramFile, Iso15765TpInterface Iso15765TransportIF);

    List<UdsDiagnosticService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, Iso15765TpInterface Iso15765TransportIF);

}
