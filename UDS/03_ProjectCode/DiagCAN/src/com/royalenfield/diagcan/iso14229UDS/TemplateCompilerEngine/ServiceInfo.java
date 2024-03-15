package com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine;

import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.UdsCommunicationInfo;

public class ServiceInfo {
    public String serviceName;

    public byte serviceID;

    public String processName;

    public String requestType;
    public boolean parameterRecord;

    public int gapTimeout;
    public UdsCommunicationInfo udsRequest;
    public UdsCommunicationInfo udsResponse;


    public ProgramFile ProgramFile;


    public String printAttributes() {
        return "Service Name: " + serviceName + "\n" +
                "Service ID: " + Integer.toHexString(serviceID) + "\n" +
                "Process Name: " + processName + "\n" +
                "Request Type: " + requestType + "\n" +
                "Parameter Record: " + parameterRecord + "\n" +
                "Gap Timeout: " + gapTimeout;
    }




}

