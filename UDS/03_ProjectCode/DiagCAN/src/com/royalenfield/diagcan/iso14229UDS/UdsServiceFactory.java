package com.royalenfield.diagcan.iso14229UDS;

import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.util.List;
import java.util.Queue;

public interface UdsServiceFactory {
        public List<DiagCanService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, ProgramFile programFile, DiagCanTp CANtp);
        public List<DiagCanService> createServiceInstances(Queue<ServiceInfo> serviceFIFO, DiagCanTp CANtp);

}
