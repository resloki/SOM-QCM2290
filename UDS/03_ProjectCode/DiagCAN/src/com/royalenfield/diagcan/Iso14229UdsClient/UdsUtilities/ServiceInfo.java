package com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities;


import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;

public class ServiceInfo {
    public String serviceName;

    public byte serviceID;

    public String processName;

    public String requestType;
    public boolean parameterRecord;

    public int gapTimeout;
    public UdsCommunicationInfo udsRequest;
    public UdsCommunicationInfo udsResponse;


    public FirmwareProgramFile firmwareProgramFile;


    @Override
    public String toString() {
        return "Service Name: " + serviceName + "\n" +
                "Service ID: " + Integer.toHexString(serviceID) + "\n" +
                "Process Name: " + processName + "\n" +
                "Request Type: " + requestType + "\n" +
                "Parameter Record: " + parameterRecord + "\n" +
                "Gap Timeout: " + gapTimeout;
    }




}

