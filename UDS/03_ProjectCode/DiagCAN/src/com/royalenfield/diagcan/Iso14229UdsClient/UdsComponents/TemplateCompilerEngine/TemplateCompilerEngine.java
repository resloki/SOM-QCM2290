package com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.TemplateCompilerEngine;


import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.UdsCommunicationInfo;
import  com.royalenfield.diagcan.UdsCallbackEventManager;

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

    final byte CLEAR_DIAGNOSTIC_INFORMATION_0x14 = 0x14;
    final byte READ_DTC_INFORMATION_0x19 = 0x19;
    final byte READ_DATA_BY_IDENTIFIER_0x22 = 0x22;

    final byte WRITE_DATA_BY_IDENTIFIER_0x2E = 0x2E;
    final byte INPUT_OUTPUT_CONTROL_BY_IDENTIFIER_0x2F = 0x2F;
    final short CRC_CALCULATION = (short) 0xFF01;


    private static final String TAG = "TemplateCompilerEngine";
    private FirmwareProgramFile firmwareProgramFile;
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    UdsTemplateParser templateParser = new UdsTemplateParser();


    /*Processing for BootLoader services*/
    public int processTemplate(InputStream inputStream, Queue<ServiceInfo> serviceFIFO, FirmwareProgramFile firmwareProgramFile) {
        try {
            this.firmwareProgramFile = firmwareProgramFile;
            callbackMgr.log(TAG,  " Starting template processing...");
            if (inputStream != null) {
                return processXml(inputStream, serviceFIFO);
            } else {
                callbackMgr.onError(-1,  " Input stream is null.");
            }
        } catch (Exception ex) {
            callbackMgr.onError(-1,  " Unexpected error: " + ex.getMessage());
        }
         return -1;
    }


    /*Processing for Application services*/
    public int processTemplate(InputStream inputStream, Queue<ServiceInfo> serviceFIFO) {
        try {
            callbackMgr.log(TAG,  " Starting template processing...");
            if (inputStream != null) {
                return processXml(inputStream, serviceFIFO);
            } else {
                callbackMgr.onError(-1,  " Input stream is null.");
            }
        } catch (Exception ex) {
            callbackMgr.onError(-1,  " Unexpected error: " + ex.getMessage());
        }
        return -1;
    }


    private int processXml(InputStream inputStream, Queue<ServiceInfo> serviceFIFO) {
        callbackMgr.log(TAG,  "Reading XML InputStream. Parsing XML...");

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

        callbackMgr.log(TAG,  "Created LinkedList for serviceFIFO.");

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
                callbackMgr.log(TAG, "Added serviceInfo to serviceFIFO \n");
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

        serviceInfo.udsRequest = new UdsCommunicationInfo();
        serviceInfo.udsResponse = new UdsCommunicationInfo();

        switch (serviceInfo.serviceID) {

            // Diagnostic Session Control, ECU Reset, Tester Present
            case DIAGNOSTIC_SESSION_CONTROL_0x10:
            case ECU_RESET_0x11:
            case TESTER_PRESENT_0x3E:
                /*
                 * Parse common request/response information for these services.
                 * This likely includes generic fields like:
                 *  - Message ID
                 *  - Subfunction
                 */
                templateParser.extractCommonReqResInfo(requestElement, serviceInfo.udsRequest);

                /*
                 * Check for presence of response parameters in the XML definition.
                 * If present, extract them using the template parser.
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    /*
                     * If response parameters are present, these services might have:
                     *  - expectResponseData: Flag indicating if a response is expected
                     * Then, parse common request/response information for the response as well.
                     */
                    serviceInfo.udsRequest.expectResponseData = templateParser.extractExpectResponseData(responseElement);
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;

            // Security Access
            case SECURITY_ACCESS_0x27:
                /*
                 * Parse Request Elements from XML for Security Access service (0x27)
                 *  - Requesting: Security access type (e.g., Login, Logout)
                 *  - SecurityLevel: Requested security level
                 *  - SPR: Suppress Positive Response flag
                 *  - optionalBytesUsed: Flag indicating presence of optional bytes
                 *  - optionalBytes (if used): List of additional bytes in the request
                 */
                serviceInfo.udsRequest.Requesting = templateParser.extractSecurityRequesting(requestElement);
                serviceInfo.udsRequest.SecurityLevel = templateParser.extractSecurityLevel(requestElement);
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                /*
                 * Parse Response Elements from XML for Security Access service (0x27)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 *  - udsResponse.optionalBytesUsed (if parameterRecord is true): Flag for optional bytes in response
                 *  - udsResponse.optionalBytes (if parameterRecord and optionalBytesUsed are true): List of additional bytes in the response
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsResponse.optionalBytesUsed = templateParser.extractOptionalBytesUsed(responseElement);
                    if (serviceInfo.udsResponse.optionalBytesUsed) {
                        serviceInfo.udsResponse.optionalBytes = templateParser.extractOptionalBytes(responseElement);
                    }
                }
                break;

            // Communication Control
            case COMMUNICATION_CONTROL_0x28:
                /*
                 * Parse Request Elements from XML for Communication Control service (0x28)
                 *  - CommunicationType: Type of communication to control
                 *  - SPR: Suppress Positive Response flag
                 *  - optionalBytesUsed: Flag indicating presence of optional bytes
                 *  - optionalBytes (if used): List of additional bytes in the request
                 */
                serviceInfo.udsRequest.CommunicationType = templateParser.extractcommunicationType(requestElement);
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }
                break;


            // Routine Control 0x31
            case ROUTINE_CONTROL_0x31:
                /*
                 * Parse Request Elements from XML for Routine Control service (0x31)
                 *  - routineIdentifierValue: Identifier of the routine to control
                 *  - programFile (if routineIdentifierValue is CRC_CALCULATION): Reference to program file for CRC calculation
                 */
                serviceInfo.udsRequest.routineIdentifierValue = templateParser.extractRoutineIdentifier(requestElement);
                if (serviceInfo.udsRequest.routineIdentifierValue == CRC_CALCULATION) {
                    serviceInfo.firmwareProgramFile = firmwareProgramFile;
                }
                templateParser.extractCommonReqResInfo(requestElement, serviceInfo.udsRequest);

                /*
                 * Parse Response Elements from XML for Routine Control service (0x31)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    /*
                     * If response parameters are present, likely includes:
                     *  - common request/response information for the response
                     */
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;



            //Clear Diagnostic Information 0x14
            case CLEAR_DIAGNOSTIC_INFORMATION_0x14:
                /*
                 * Parse Request Elements from XML for Clear Diagnostic Information service (0x14)
                 *  - DTCInfo: Diagnostic Trouble Code information format
                 */
                serviceInfo.udsRequest.DTCInfo = templateParser.extractDTCFormat(requestElement);

                /*
                 * Parse Response Elements from XML for Clear Diagnostic Information service (0x14)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 *  - udsRequest.expectResponseData (if parameterRecord is true): Flag indicating expected response data
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsRequest.expectResponseData = templateParser.extractExpectResponseData(responseElement);
                }
                break;


            //Read DTC Information 0x19
            case READ_DTC_INFORMATION_0x19:
                /*
                 * Parse Request Elements from XML for Read DTC Information service (0x19)
                 *  - sessionName: Diagnostic session name
                 *  - subfunctionID: Subfunction identifier
                 *  - DTCInfo: Diagnostic Trouble Code information format
                 */
                serviceInfo.udsRequest.sessionName = templateParser.extractSessionName(requestElement);
                serviceInfo.udsRequest.subfunctionID = templateParser.extractSubfunctionID(requestElement);
                serviceInfo.udsRequest.DTCInfo = templateParser.extractDTCFormat(requestElement);

                /*
                 * Parse Response Elements from XML for Read DTC Information service (0x19)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 *  - udsRequest.expectResponseData (if parameterRecord is true): Flag indicating expected response data
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsRequest.expectResponseData = templateParser.extractExpectResponseData(responseElement);
                }
                break;


            //Input Output Control by Identifier 0x2f
            case INPUT_OUTPUT_CONTROL_BY_IDENTIFIER_0x2F:
                /*
                 * Parse Request Elements from XML for Input/Output Control by Identifier service (0x2F)
                 *  - dataIdentifierInfo: Information about the data identifier
                 *  - IOCP: Input/Output Control Parameter information
                 */
                serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(requestElement);
                serviceInfo.udsRequest.IOCP = templateParser.extractIOCPInfo(requestElement);

                /*
                 * Parse Response Elements from XML for Input/Output Control by Identifier service (0x2F)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 *  - udsRequest.dataIdentifierInfo (if parameterRecord is true): Information about the data identifier in the response
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(responseElement);
                }
                break;

            //Write Data by Identifier 0x2e
            case WRITE_DATA_BY_IDENTIFIER_0x2E:
                /*
                 * Parse Request Elements from XML for Write Data by Identifier service (0x2E)
                 *  - dataIdentifierInfo: Information about the data identifier
                 */
                serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(requestElement);

                /*
                 * Parse Response Elements from XML for Write Data by Identifier service (0x2E)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 *  - udsRequest.dataIdentifierInfo (if parameterRecord is true): Information about the data identifier in the response
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(responseElement);
                }
                break;


            //Request Download 0x34
            case REQUEST_DOWNLOAD_0x34:
                /*
                 * Parse Request Elements from XML for Request Download service (0x34)
                 *  - SPR: Suppress Positive Response flag
                 *  - optionalBytesUsed: Flag indicating presence of optional bytes
                 *  - programFile (assumed): Reference to program file for download
                 *  - optionalBytes (if used): List of additional bytes in the request
                 */
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                serviceInfo.firmwareProgramFile = firmwareProgramFile;
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                /*
                 * Parse Response Elements from XML for Request Download service (0x34)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    /*
                     * If response parameters are present, likely includes:
                     *  - common request/response information for the response
                     */
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;


            //Transfer Data 0x36
            case TRANSFER_DATA_0x36:
                /*
                 * Parse Request Elements from XML for Transfer Data service (0x36)
                 *  - BlockSequenceCounter: Block sequence counter for data transfer
                 *  - SPR: Suppress Positive Response flag
                 *  - optionalBytesUsed: Flag indicating presence of optional bytes
                 *  - programFile (assumed): Reference to program file for transfer
                 *  - optionalBytes (if used): List of additional bytes in the request
                 */
                serviceInfo.udsRequest.BlockSequenceCounter = templateParser.extractBlockSequenceCounter(requestElement);
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                serviceInfo.firmwareProgramFile = firmwareProgramFile;
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                /*
                 * Parse Response Elements from XML for Transfer Data service (0x36)
                 *  - parameterRecord: Flag indicating presence of response parameters
                 */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    /*
                     * If response parameters are present, likely includes:
                     *  - common request/response information for the response
                     */
                    templateParser.extractCommonReqResInfo(responseElement, serviceInfo.udsResponse);
                }
                break;

            //Request Transfer Exit 0x37
            case REQUEST_TRANSFER_EXIT_0x37:
                /* Request Parameters */
                serviceInfo.udsRequest.SPR = templateParser.extractSuppressPositiveResponse(requestElement);
                serviceInfo.udsRequest.optionalBytesUsed = templateParser.extractOptionalBytesUsed(requestElement);
                if (serviceInfo.udsRequest.optionalBytesUsed) {
                    serviceInfo.udsRequest.optionalBytes = templateParser.extractOptionalBytes(requestElement);
                }

                /* Response Parameters */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {

                    serviceInfo.udsResponse.optionalBytesUsed = templateParser.extractOptionalBytesUsed(responseElement);
                    if (serviceInfo.udsResponse.optionalBytesUsed) {
                        serviceInfo.udsResponse.optionalBytes = templateParser.extractOptionalBytes(responseElement);
                    }
                }
                break;



            //Read Data by Identifier 0x22
            case READ_DATA_BY_IDENTIFIER_0x22:

                /* Request Parameters */
                serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(requestElement);

                /* Response Parameters */
                serviceInfo.parameterRecord = templateParser.extractParameterRecord(responseElement);
                if (serviceInfo.parameterRecord) {
                    serviceInfo.udsRequest.expectResponseData = templateParser.extractExpectResponseData(responseElement);
                    serviceInfo.udsRequest.dataIdentifierInfo = templateParser.extractDataIdentifierInfo(responseElement);
                }
                break;

            default:
                throw new IllegalStateException("No Service Configuration for : " + Integer.toHexString(serviceInfo.serviceID));

        }


        callbackMgr.log(TAG, "Service Info Attributes: \n" + serviceInfo.toString());
        return;
    }


}