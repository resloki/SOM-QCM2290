package com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.TemplateCompilerEngine;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.DTCFormat;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.DataIdentifierInfo;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.UdsCommunicationInfo;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UdsTemplateParser {
    String extractServiceName(Element serviceElement) {
        try {
            String name = serviceElement.getAttribute("Name");
            return name;
        } catch (Exception e) {
            return "NoServiceName";
        }
    }

    public byte extractServiceID(Element serviceElement) throws SAXParseException {
        try {
            String sidAttribute = serviceElement.getAttribute("SID");
            if (sidAttribute != null && !sidAttribute.isEmpty()) {
                int serviceID_int = Integer.parseInt(sidAttribute.substring(2), 16);
                return (byte) serviceID_int;
            } else {
                throw new SAXParseException(UdsParseExceptionType.MISSING_SID_ATTRIBUTE.name(), null);
            }
        } catch (NumberFormatException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_SID_FORMAT.name(), null);
        }
    }

    public String extractProcessName(Element serviceElement) throws SAXParseException {
        try {
            NodeList processNameNodes = serviceElement.getElementsByTagName("ProcessName");
            if (processNameNodes.getLength() > 0) {
                String name = processNameNodes.item(0).getTextContent();
                return name;
            } else {
                return "MISSING_PROCESS_NAME";
            }
        } catch (Exception e) {
            return "MISSING_PROCESS_NAME";
        }
    }

    public String extractRequestType(Element serviceElement) throws SAXParseException {
        try {
            NodeList requestTypeNodes = serviceElement.getElementsByTagName("RequestType");
            if (requestTypeNodes.getLength() > 0) {
                String requestType = requestTypeNodes.item(0).getTextContent();
                return requestType;
            } else {
                throw new SAXParseException(UdsParseExceptionType.MISSING_REQUEST_TYPE.name(), null);
            }
        } catch (Exception e) {
            return UdsParseExceptionType.MISSING_REQUEST_TYPE.name();
        }
    }

    public String extractSessionName(Element serviceElement) throws SAXParseException {
        try {
            String sessionName = serviceElement
                    .getElementsByTagName("Session")
                    .item(0)
                    .getAttributes()
                    .getNamedItem("name")
                    .getTextContent();
            return sessionName;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.MISSING_SESSION_NAME.name(), null);
        }
    }

    public byte extractSubfunctionID(Element serviceElement) throws SAXParseException {
        try {
            String typeValue = serviceElement
                    .getElementsByTagName("Session")
                    .item(0)
                    .getAttributes()
                    .getNamedItem("SubfunctionID")
                    .getTextContent();
            int sessionTypeHex = Integer.parseInt(typeValue.replaceFirst("^0[xX]", ""), 16);
            byte sessionType = (byte) sessionTypeHex;
            return sessionType;
        } catch (NumberFormatException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_SUBFUNCTION_ID.name(), null);
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.MISSING_SUBFUNCTION_ID.name(), null);
        }
    }

    public boolean extractSuppressPositiveResponse(Element serviceElement) throws SAXParseException {
        try {
            boolean suppressPositiveResponse = Boolean.parseBoolean(serviceElement
                    .getElementsByTagName("SuppressPositiveResponse")
                    .item(0)
                    .getTextContent());
            return suppressPositiveResponse;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.ERROR_PARSING_SUPPRESS_POSITIVE_RESPONSE.name(), null);
        } catch (Exception e) {
            return false;
        }
    }


    public boolean extractExpectResponseData(Element serviceElement) throws SAXParseException {
        try {
            boolean suppressPositiveResponse = Boolean.parseBoolean(serviceElement
                    .getElementsByTagName("ExpectResponseData")
                    .item(0)
                    .getTextContent());
            return suppressPositiveResponse;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.ERROR_PARSING_EXPECT_RESPONSE_DATA.name(), null);
        } catch (Exception e) {
            return false;
        }
    }

    public DTCFormat extractDTCFormat(Element serviceElement) throws SAXParseException {
        try {
            Element dtcFormatElement = (Element) serviceElement.getElementsByTagName("DTCFormat").item(0);

            String formatIDString = dtcFormatElement.getElementsByTagName("FormatID").item(0).getTextContent();
            byte formatID = Byte.parseByte(formatIDString.replace("0x", ""), 16);


            // Cast Node to Element for accessing attributes
            Element filteringElement = (Element) dtcFormatElement.getElementsByTagName("Filtering").item(0);
            String modeValue = filteringElement.getAttribute("Mode");
            String maskValue = filteringElement.getAttribute("Mask");

            byte mode = Byte.parseByte(modeValue.replace("0x", ""), 16);
            short mask = Short.parseShort(maskValue.replace("0x", ""), 16);

            return new DTCFormat(formatID, mode, mask);

        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.ERROR_PARSING_DTC_FORMAT.name(), null);
        } catch (Exception e) {
            // Handle other potential parsing errors or return a default DTCFormat
            return new DTCFormat((byte) 0x00, (byte) 0xFF, (short) 0xFFFF);  // Default values
        }
    }


    public Entry<Byte, String> extractcommunicationType(Element serviceElement) throws SAXParseException {

        NodeList CommunicationType = serviceElement.getElementsByTagName("CommunicationType");
        if (CommunicationType.getLength() > 0) {
            Element CommunicationTypeElement = (Element) CommunicationType.item(0);

            String numberStr = CommunicationTypeElement.getAttribute("value");
            String name = CommunicationTypeElement.getAttribute("name");
            byte number = (byte) Integer.parseInt(numberStr.substring(2), 16);
            return new SimpleEntry<>(number, name);
        } else {
            throw new SAXParseException("No Data Identifier elements found", null);
        }

    }

    public Entry<Byte, String> extractIOCPInfo(Element serviceElement) throws SAXParseException {

        NodeList IOControlParameter = serviceElement.getElementsByTagName("IOControlParameter");
        if (IOControlParameter.getLength() > 0) {
            Element CommunicationTypeElement = (Element) IOControlParameter.item(0);

            String numberStr = CommunicationTypeElement.getAttribute("value");
            String name = CommunicationTypeElement.getAttribute("name");
            byte number = (byte) Integer.parseInt(numberStr.substring(2), 16);
            return new SimpleEntry<>(number, name);
        } else {
            throw new SAXParseException("No Data Identifier elements found", null);
        }

    }

    public boolean extractParameterRecord(Element serviceElement) throws SAXParseException {
        try {
            boolean parameterRecord = Boolean.parseBoolean(serviceElement
                    .getElementsByTagName("ParameterRecord")
                    .item(0)
                    .getTextContent());
            return parameterRecord;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.ERROR_PARSING_PARAMETER_RECORD.name(), null);
        } catch (Exception e) {
            return false;
        }
    }


    public String extractSecurityLevel(Element serviceElement) throws Exception {
        try {
            String securityLevel = serviceElement
                    .getElementsByTagName("SecurityLevel")
                    .item(0)
                    .getTextContent();
            return securityLevel;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.MISSING_SECURITY_LEVEL.name(), null);
        } catch (NumberFormatException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_SECURITY_LEVEL.name(), null);
        }
    }

    public byte extractBlockSequenceCounter(Element serviceElement) throws Exception {
        try {
            String counterStr = serviceElement.getElementsByTagName("BlockSequenceCounter").item(0).getTextContent().trim();
            // Remove "0x" prefix if present
            if (counterStr.startsWith("0x")) {
                counterStr = counterStr.substring(2);
            }
            // Parse the counter string as a hexadecimal value
            byte blockSequenceCounter = (byte) Integer.parseInt(counterStr, 16);
            return blockSequenceCounter;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.MISSING_BLOCK_SEQUENCE_COUNTER.name(), null);
        } catch (NumberFormatException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_BLOCK_SEQUENCE_COUNTER.name(), null);
        }
    }


    public String extractSecurityRequesting(Element serviceElement) throws SAXParseException {
        try {
            String requesting = serviceElement
                    .getElementsByTagName("Requesting")
                    .item(0)
                    .getTextContent();
            return requesting;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.MISSING_SECURITY_REQUESTING.name(), null);
        }
    }

    public boolean extractOptionalBytesUsed(Element serviceElement) throws SAXParseException {
        try {
            boolean optionalBytesUsed = Boolean.parseBoolean(serviceElement
                    .getElementsByTagName("OptionalBytes")
                    .item(0)
                    .getAttributes()
                    .getNamedItem("used")
                    .getTextContent());
            return optionalBytesUsed;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.ERROR_PARSING_OPTIONAL_BYTES_USED.name(), null);
        } catch (Exception e) {
            throw new SAXParseException(UdsParseExceptionType.ERROR_PARSING_OPTIONAL_BYTES_USED.name(), null);
        }
    }

    public int extractOptionalBytesBufferLength(Element serviceElement) throws SAXParseException {
        try {
            String bufferLengthAttribute = serviceElement.getElementsByTagName("OptionalBytes")
                    .item(0)
                    .getAttributes()
                    .getNamedItem("bufferlength")
                    .getTextContent();
            return Integer.parseInt(bufferLengthAttribute.substring(2), 16);
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.MISSING_OPTIONAL_BYTES_ELEMENT.name(), null);
        } catch (NumberFormatException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_OPTIONAL_BYTES_BUFFER_LENGTH.name(), null);
        }
    }

    public short extractRoutineIdentifier(Element serviceElement) throws SAXParseException {
        try {
            String typeValue = serviceElement
                    .getElementsByTagName("RoutineIdentifier")
                    .item(0)
                    .getTextContent();
            int routineIdentifier = Integer.parseInt(typeValue.substring(2), 16);
            return (short) routineIdentifier;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_ROUTINE_IDENTIFIER.name(), null);
        } catch (NumberFormatException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_ROUTINE_IDENTIFIER.name(), null);
        }
    }


    public Map<Integer, Byte> extractOptionalBytes(Element serviceElement) throws SAXParseException {
        try {
            Map<Integer, Byte> optionalBytes = new HashMap<>();
            Element optionalBytesElement = (Element) serviceElement.getElementsByTagName("OptionalBytes").item(0);
            NodeList byteNodes = optionalBytesElement.getElementsByTagName("Byte");
            for (int i = 0; i < byteNodes.getLength(); i++) {
                Element byteElement = (Element) byteNodes.item(i);
                int index = Integer.parseInt(byteElement.getAttribute("index"));
                byte value = Byte.parseByte(byteElement.getAttribute("value").substring(2), 16);
                optionalBytes.put(index, value);
            }
            return optionalBytes;
        } catch (NullPointerException e) {
            throw new SAXParseException(UdsParseExceptionType.MISSING_OPTIONAL_BYTES_ELEMENT.name(), null);
        } catch (NumberFormatException e) {
            throw new SAXParseException(UdsParseExceptionType.INVALID_OPTIONAL_BYTES_FORMAT.name(), null);
        }
    }


    public DataIdentifierInfo extractDataIdentifierInfo(Element serviceElement) throws SAXParseException {
        NodeList dataIdentifierNodes = serviceElement.getElementsByTagName("DataIdentifierInfo");
        if (dataIdentifierNodes.getLength() > 0) {
            Element dataIdentifierElement = (Element) dataIdentifierNodes.item(0);
            String numberAttribute = dataIdentifierElement.getAttribute("Number");
            int numberInt = Integer.parseInt(numberAttribute.substring(2), 16);
            short numberShort = (short) numberInt;
            String name = dataIdentifierElement.getAttribute("Name");

            // Extracting DataRecord information
            Element dataRecordElement = (Element) dataIdentifierElement.getElementsByTagName("DataRecord").item(0);
            boolean dataRecordUsed = Boolean.parseBoolean(dataRecordElement.getAttribute("used"));
            List<Byte> byteValues = new ArrayList<>();
            byte bufferLength = 0;
            if (dataRecordUsed) {
                bufferLength = Byte.parseByte(dataRecordElement.getAttribute("BufferLength").substring(2), 16);

                // Extracting Byte elements
                NodeList byteNodes = dataRecordElement.getElementsByTagName("Byte");
                for (int i = 0; i < byteNodes.getLength(); i++) {
                    Element byteElement = (Element) byteNodes.item(i);
                    byteValues.add(Byte.parseByte(byteElement.getTextContent().substring(2), 16));
                }
            }
            return new DataIdentifierInfo(numberShort, name, dataRecordUsed, bufferLength, byteValues);
        } else {
            throw new SAXParseException(UdsParseExceptionType.INVALID_DATA_IDENTIFIER.name(), null);
        }

    }




    public void extractCommonReqResInfo(Element serviceElement, UdsCommunicationInfo reqResInfo) throws SAXParseException {

        reqResInfo.sessionName = extractSessionName(serviceElement);
        reqResInfo.subfunctionID = extractSubfunctionID(serviceElement);
        reqResInfo.SPR = extractSuppressPositiveResponse(serviceElement);
        reqResInfo.optionalBytesUsed = extractOptionalBytesUsed(serviceElement);
        if (reqResInfo.optionalBytesUsed) {
            reqResInfo.optionalBytesBufferLength = extractOptionalBytesBufferLength(serviceElement);
            reqResInfo.optionalBytes = extractOptionalBytes(serviceElement);
        }

    }

}
