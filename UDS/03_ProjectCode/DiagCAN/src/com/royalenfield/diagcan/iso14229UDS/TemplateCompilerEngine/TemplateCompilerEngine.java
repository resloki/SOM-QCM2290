package com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine;

import android.util.Pair;

import com.royalenfield.diagcan.UdsCallbackEventManager;
import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.UdsCommunicationInfo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class TemplateCompilerEngine {
    UdsCallbackEventManager callbackMgr = UdsCallbackEventManager.getInstance();
    final byte DIAGNOSTIC_SESSION_CONTROL_0x10 = 0x10;
    final byte ECU_RESET_0x11 = 0x11;
    final byte SECURITY_ACCESS_0x27 = 0x27;
    final byte COMMUNICATION_CONTROL_0x28 = 0x28;
    final byte TESTER_PRESENT_0x3E = 0x3E;
    final byte ROUTINE_CONTROL_0x31 = 0x31;
    final byte REQUEST_DOWNLOAD_0x34 = 0x34;
    final byte REQUEST_UPLOAD_0x35 = 0x35;
    final byte TRANSFER_DATA_0x36 = 0x36;
    final byte REQUEST_TRANSFER_EXIT_0x37 = 0x37;

    final byte REQUEST_TRANSFER_DATA_0x28 = 0x28;
    final byte CLEAR_DIAGNOSTIC_INFORMATION_0x14 = 0x14;
    final byte READ_DTC_INFORMATION_0x19 = 0x19;
    final byte READ_DATA_BY_IDENTIFIER_0x22 = 0x22;
    final byte READ_MEMORY_BY_ADDRESS_0x23 = 0x23;
    final byte WRITE_DATA_BY_IDENTIFIER_0x2E = 0x2E;
    final byte INPUT_OUTPUT_CONTROL_BY_IDENTIFIER_0x2F = 0x2F;


    private static final String TAG = "TemplateCompilerEngine";
    private ProgramFile programFile;
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    UdsTemplateParser templateParser = new UdsTemplateParser();


    /*Processing for BootLoader services*/
    public int processTemplate(InputStream inputStream, Queue<ServiceInfo> serviceFIFO, ProgramFile programFile) {
        String methodName = "Method Name: processTemplate";
        try {
            this.programFile = programFile;
            callbackMgr.Log(TAG, methodName + " Starting template processing...");
            if (inputStream != null) {
                return processXml(inputStream, serviceFIFO);
            } else {
                callbackMgr.onError(-1, methodName + " Input stream is null.");
            }
        } catch (Exception ex) {
            callbackMgr.onError(-1, methodName + " Unexpected error: " + ex.getMessage());
        }
        return -1;
    }


    /*Processing for Application services*/
    public int processTemplate(InputStream inputStream, Queue<ServiceInfo> serviceFIFO) {
        String methodName = "Method Name: processTemplate";
        try {
            callbackMgr.Log(TAG, methodName + " Starting template processing...");
            if (inputStream != null) {
                return processXml(inputStream, serviceFIFO);
            } else {
                callbackMgr.onError(-1, methodName + " Input stream is null.");
            }
        } catch (Exception ex) {
            callbackMgr.onError(-1, methodName + " Unexpected error: " + ex.getMessage());
        }
        return -1;
    }


    private int processXml(InputStream inputStream, Queue<ServiceInfo> serviceFIFO) {
        String methodName = "methodName: processXml";
        callbackMgr.Log(TAG, methodName + "Reading XML InputStream. Parsing XML...");

        Document document = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(inputStream);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        Element rootElement = document.getDocumentElement();
        NodeList serviceNodes = rootElement.getElementsByTagName("Service");

        callbackMgr.Log(TAG, methodName + "Created LinkedList for serviceFIFO.");

        for (int i = 0; i < serviceNodes.getLength(); i++) {
            Node serviceNode = serviceNodes.item(i);

            if (serviceNode.getNodeType() == Node.ELEMENT_NODE) {
                Element serviceElement = (Element) serviceNode;
                ServiceInfo serviceInfo = new ServiceInfo();

                try {
                    extractServiceInfo(serviceElement, serviceInfo);
                } catch (Exception e) {
                    byte SID = serviceInfo.serviceID;
                    String errorCode = e.getMessage();
                    callbackMgr.onError(-1, "Error occurred during template processing for Service" + Integer.toHexString(SID) + " Error: " + errorCode);
                    return -1;
                }

                serviceFIFO.add(serviceInfo);
                callbackMgr.Log(TAG, "Added serviceInfo to serviceFIFO \n");
            }
        }
        return 0;
    }


    protected void extractServiceInfo(Element serviceElement, ServiceInfo serviceInfo) throws Exception {


        serviceInfo.serviceName = templateParser.extractServiceName(serviceElement);
        serviceInfo.serviceID = templateParser.extractServiceID(serviceElement);
        serviceInfo.processName = templateParser.extractProcessName(serviceElement);
        serviceInfo.requestType = templateParser.extractRequestType(serviceElement);

        Element requestElement = (Element) serviceElement.getElementsByTagName("Request").item(0);
        Element responseElement = (Element) serviceElement.getElementsByTagName("Response").item(0);

        switch (serviceInfo.serviceID) {
            case DIAGNOSTIC_SESSION_CONTROL_0x10:

            case ECU_RESET_0x11:


            case TESTER_PRESENT_0x3E:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                templateParser.extractCommonReqResInfo(requestElement, serviceInfo.udsRequest);
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;


            case SECURITY_ACCESS_0x27:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                serviceInfo.udsRequest.Requesting = templateParser.extractSecurityRequesting(requestElement);
                serviceInfo.udsRequest.SecurityLevel = templateParser.extractSecurityLevel(requestElement);
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    serviceInfo.udsResponse.optionalBytesUsed = templateParser.extractOptionalBytesUsed(responseElement);
                    if (serviceInfo.udsResponse.optionalBytesUsed) {
                        serviceInfo.udsResponse.optionalBytes = templateParser.extractOptionalBytes(responseElement);
                    }
                }
                break;

            case COMMUNICATION_CONTROL_0x28:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                Pair<Byte, String> communicationType = templateParser.extractcommunicationType(responseElement);
                serviceInfo.udsResponse.communicationType = communicationType.first;
                serviceInfo.udsResponse.communicationName = communicationType.second;
                serviceInfo.udsResponse.SPR = templateParser.extractSuppressPositiveResponse(responseElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    serviceInfo.udsResponse.optionalBytesUsed = templateParser.extractOptionalBytesUsed(responseElement);
                    if (serviceInfo.udsResponse.optionalBytesUsed) {
                        serviceInfo.udsResponse.optionalBytes = templateParser.extractOptionalBytes(responseElement);
                    }
                }
                break;


            case ROUTINE_CONTROL_0x31:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                serviceInfo.udsRequest.routineIdentifierValue = templateParser.extractRoutineIdentifier(requestElement);
                templateParser.extractCommonReqResInfo(requestElement, serviceInfo.udsRequest);
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;

            case CLEAR_DIAGNOSTIC_INFORMATION_0x14:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                serviceInfo.udsRequest.sessionName = templateParser.extractSessionName(requestElement);
                serviceInfo.udsRequest.subfunctionID = templateParser.extractSubfunctionID(requestElement);

                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(responseElement);
                }
                break;


            case INPUT_OUTPUT_CONTROL_BY_IDENTIFIER_0x2F:


            case WRITE_DATA_BY_IDENTIFIER_0x2E:

                serviceInfo.udsRequest = new UdsCommunicationInfo();
                serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(requestElement);

                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(responseElement);
                }
                break;


            case REQUEST_DOWNLOAD_0x34:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                serviceInfo.ProgramFile = programFile;
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;


            case TRANSFER_DATA_0x36:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                serviceInfo.udsRequest.BlockSequenceCounter = templateParser.extractBlockSequenceCounter(requestElement);
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                serviceInfo.ProgramFile = programFile;
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;

            case REQUEST_TRANSFER_EXIT_0x37:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    serviceInfo.udsResponse.optionalBytesUsed = templateParser.extractOptionalBytesUsed(responseElement);
                    if (serviceInfo.udsResponse.optionalBytesUsed) {
                        serviceInfo.udsResponse.optionalBytes = templateParser.extractOptionalBytes(responseElement);
                    }
                }
                break;

            case READ_DATA_BY_IDENTIFIER_0x22:
                serviceInfo.udsRequest = new UdsCommunicationInfo();
                Pair<Short, String> dataIdentifierPair;

                /*Request Parameters*/
                dataIdentifierPair = templateParser.extractDataIdentifier(requestElement);
                serviceInfo.udsRequest.dataIdentifierInfo.number = dataIdentifierPair.first;
                serviceInfo.udsRequest.dataIdentifierInfo.name = dataIdentifierPair.second;

                /*Response Parameters*/
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse = new UdsCommunicationInfo();
                    dataIdentifierPair = templateParser.extractDataIdentifier(responseElement);
                    serviceInfo.udsRequest.dataIdentifierInfo.number = dataIdentifierPair.first;
                    serviceInfo.udsRequest.dataIdentifierInfo.name = dataIdentifierPair.second;
                }

            default:
                throw new IllegalStateException("No Service Configuration for : " + Integer.toHexString(serviceInfo.serviceID));
        }
        callbackMgr.Log(TAG, "Service Info Attributes: \n" + serviceInfo.printAttributes());
        return;
    }


}