package DBC_Converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GenerateJavaFile {

    DbcMain front = new DbcMain();
    int Controller_Endianness = 0;
    private boolean contentLoaded;
    protected StringBuilder sourceFile_ConverterInitialize = new StringBuilder(100000);
    protected StringBuilder sourceFile_ConverterInterface = new StringBuilder(100000);
    protected StringBuilder sourceFile_SignalConverter = new StringBuilder(100000);
    StringBuilder sb = new StringBuilder(512);
    private String nameDrv = "";
    int validity_Count = 0;
    String path = null;
    SourceFileDescriptor _files = new SourceFileDescriptor();
    public String[] typedata = {"int8_t", "int16_t", "int32_t", "int64_t", "uint8_t", "uint16_t", "uint32_t",
            "uint64_t"};

    String[] readMask = {"SIGNLE_READ_Mask0", "SIGNLE_READ_Mask1", "SIGNLE_READ_Mask2", "SIGNLE_READ_Mask3",
            "SIGNLE_READ_Mask4", "SIGNLE_READ_Mask5", "SIGNLE_READ_Mask6", "SIGNLE_READ_Mask7", "SIGNLE_READ_Mask8"};

    String[] writeMask = {"SIGNLE_WRITE_Mask0", "SIGNLE_WRITE_Mask1", "SIGNLE_WRITE_Mask2", "SIGNLE_WRITE_Mask3",
            "SIGNLE_WRITE_Mask4", "SIGNLE_WRITE_Mask5", "SIGNLE_WRITE_Mask6", "SIGNLE_WRITE_Mask7"};

    String[] ShiftMask = {" << ", " >> "};

    String[] typeprint = {"int8_t", "int16_t", "int32_t", "int64_t", "uint8_t", "uint16_t", "uint32_t", "uint64_t"};

    public void generateTheFile(String dbcPath, int selectedIndex) throws IOException {
        Controller_Endianness = selectedIndex;
        SourceFileDescriptor file = new SourceFileDescriptor();
        String funcUtilName;
        String[] seperator = {"\\\\", ".dbc"};
        StringReader dbcreader = new StringReader(new String(Files.readAllBytes(Paths.get(dbcPath))));

        DbcAnalizer d = new DbcAnalizer();
        d.trimDbcRawStream(dbcreader);
        String[] strList = Arrays.stream(dbcPath.split(String.join("|", seperator))).filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        dbcPath = "";
        int k;
        for (k = 0; k < strList.length - 1; k++) {
            dbcPath += strList[k] + "\\";
        }

        dbcPath = dbcPath.toString();
        String path = dbcPath;
        String sourceName = strList[k];
        List<String> funcSignatures = new ArrayList<String>();
        file.setDir(path);
        String incName = sourceName;
        file.setFiles(file.getDir() + "\\" + incName.toLowerCase());
        file.setFiles(file.getDir() + "\\" + incName);
        funcUtilName = incName;
        sourceFile_ConverterInitialize.setLength(0);

        sourceFile_ConverterInitialize.append("public class " + incName + "_ConverterInitialize {").append("\n");
        sourceFile_ConverterInitialize.append("\n");
        long startBit = 0;
        for (MessageDescriptor msg : d.getMessages()) {
            for (SignalBitsDesc msg1 : msg.getSignals()) {

                String mask = update_Mask(msg1);

                for (int i = 0; i < 8; i++) {
                    if (msg1.getMaskValue()[i] != 0) {
                        msg1.getMaskValueToString()[i] = msg.getMessageName().toUpperCase() + "_"
                                + msg1.getFieldName().toUpperCase() + "_MASK" + i;

                        sourceFile_ConverterInitialize.append("public final int ").append(msg.getMessageName().toUpperCase()).append("_")
                                .append(msg1.getFieldName().toUpperCase()).append("_MASK").append(i).append("=")
                                .append(msg1.getMaskValue()[i]).append(";\n");
                    }
                }
            }
            sourceFile_ConverterInitialize.append("\n");
        }
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask0 = 0;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask1 = 0x01;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask2 = 0x03;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask3 = 0x07;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask4 = 0x0F;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask5 = 0x1F;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask6 = 0x3F;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask7 = 0x7F;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_READ_Mask8 = 0xFF;\n");
        sourceFile_ConverterInitialize.append("\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask0 = 0x80;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask1 = 0xC0;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask2 = 0xE0;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask3 = 0xF0;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask4 = 0xF8;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask5 = 0xFC;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask6 = 0xFE;\n");
        sourceFile_ConverterInitialize.append("public final int SIGNLE_WRITE_Mask7 = 0xFF;\n");
        sourceFile_ConverterInitialize.append("\n");

        for (MessageDescriptor msg : d.getMessages()) {
        	sourceFile_ConverterInitialize.append("/* public final int @").append(msg.getMessageName().toUpperCase())
                    .append(" CAN MESSAGE = ").append(msg.getMessageId()).append("*/\n");
        	sourceFile_ConverterInitialize.append("public final int ").append(msg.getMessageName().toUpperCase()).append("_ID = ")
                    .append(msg.getMessageId()).append(";\n");
        	sourceFile_ConverterInitialize.append("public final int ").append(msg.getMessageName().toUpperCase()).append("_IDE = ")
                    .append(msg.getIsExtended()).append(";\n");
        	sourceFile_ConverterInitialize.append("public final int ").append(msg.getMessageName().toUpperCase()).append("_DLC = ")
                    .append(msg.getDataLen()).append(";\n");

            startBit = 0;
            for (SignalBitsDesc msg1 : msg.getSignals()) {
            	sourceFile_ConverterInitialize.append("public final double ").append(msg.getMessageName().toUpperCase()).append("_")
                        .append(msg1.getFieldName().toUpperCase()).append("_FACTOR = ").append(msg1.getFactor())
                        .append(";\n");
            	sourceFile_ConverterInitialize.append("public final int ").append(msg.printMsgIDName().toUpperCase()).append("_")
                        .append(msg1.getFieldName().toUpperCase()).append("_STARTBIT = ").append(msg1.getStartBit())
                        .append(";\n");
            	sourceFile_ConverterInitialize.append("public final double ").append(msg.printMsgIDName().toUpperCase()).append("_")
                        .append(msg1.getFieldName().toUpperCase()).append("_OFFSET = ").append(msg1.getOffset())
                        .append(";\n");
            	sourceFile_ConverterInitialize.append("public final double ").append(msg.printMsgIDName().toUpperCase()).append("_")
                        .append(msg1.getFieldName().toUpperCase()).append("_MIN = ").append(msg1.getMinValue())
                        .append(";\n");
            	sourceFile_ConverterInitialize.append("public final double ").append(msg.printMsgIDName().toUpperCase()).append("_")
                        .append(msg1.getFieldName().toUpperCase()).append("_MAX = ").append(msg1.getMaxValue())
                        .append(";\n");
            }
            sourceFile_ConverterInitialize.append("\n");

            sourceFile_ConverterInitialize.append("public static class ").append(msg.getMessageName()).append("_t").append(" { ")
                    .append("\n");
            sourceFile_ConverterInitialize.append("\n");
            for (SignalBitsDesc msg1 : msg.getSignals()) {
                if (msg1.getLengthBit() <= 8) {
                	sourceFile_ConverterInitialize.append("  ").append("public float ").append(msg1.getFieldName()).append(";\n");

                } else if (msg1.getLengthBit() <= 16) {
                	sourceFile_ConverterInitialize.append("  ").append("public float ").append(msg1.getFieldName()).append(";\n");
                } else if (msg1.getLengthBit() <= 32) {
                	sourceFile_ConverterInitialize.append("  ").append("public float ").append(msg1.getFieldName()).append(";\n");
                } else {
                	sourceFile_ConverterInitialize.append("  ").append("public double ").append(msg1.getFieldName()).append(";\n");
                }

                validity_Count += (int) msg1.getLengthBit();
                startBit += (int) msg1.getLengthBit();
            }
            sourceFile_ConverterInitialize.append("}\n");
        }
        sourceFile_ConverterInitialize.append("}\n");
        
        String fileWriteInitialize = "";

        for (int i = 0; i < strList.length - 1; i++) {
        	fileWriteInitialize += strList[i] + "\\\\";
        }

        fileWriteInitialize = fileWriteInitialize + strList[strList.length - 1] + "_ConverterInitialize.java";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWriteInitialize))) {
            bufferedWriter.write(sourceFile_ConverterInitialize.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sourceFile_ConverterInterface.setLength(0);

        sourceFile_ConverterInterface.append("interface " + incName +"_ConverterInterface {\n ");

        for (MessageDescriptor msg : d.getMessages()) {
        	sourceFile_ConverterInterface.append("long Deserialize_").append(msg.getMessageName()).append("( " + incName + "_ConverterInitialize.")
                    .append(msg.getMessageName() + "_t")
                    .append(" messages, byte[] data_deserialize_" + msg.getMessageName() + ");").append("\n");
        	sourceFile_ConverterInterface.append("long Serialize_").append(msg.getMessageName()).append("( " + incName + "_ConverterInitialize.")
                    .append(msg.getMessageName() + "_t")
                    .append(" messages, byte[] data_serialize_" + msg.getMessageName() + ");").append("\n");
        }

        sourceFile_ConverterInterface.append("}\n");
        sourceFile_ConverterInterface.append("\n");
        
        String fileWriteConverterInterface = "";

        for (int i = 0; i < strList.length - 1; i++) {
        	fileWriteConverterInterface += strList[i] + "\\\\";
        }

        fileWriteConverterInterface = fileWriteConverterInterface + strList[strList.length - 1] + "_ConverterInterface.java";
        
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWriteConverterInterface))) {
            bufferedWriter.write(sourceFile_ConverterInterface.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sourceFile_SignalConverter.setLength(0);

        sourceFile_SignalConverter.append("public class " + incName + "_SignalConverter implements " + incName +"_ConverterInterface  {\n");
        int msg_LengthBit = 0;
        String data;

        for (MessageDescriptor msg : d.getMessages()) {
        	sourceFile_SignalConverter.append("public long Deserialize_").append(msg.getMessageName()).append("( " + incName + "_ConverterInitialize.")
                    .append(msg.getMessageName() + "_t").append((" messages, byte[] data)\n"));
        	sourceFile_SignalConverter.append("{\n");
        	sourceFile_SignalConverter.append(" " + incName + "_ConverterInitialize can = new " + incName + "_ConverterInitialize();\n");

            for (SignalBitsDesc msg1 : msg.getSignals()) {

                if (msg1.getLengthBit() <= 8) {

                    data = "messages." + msg1.getFieldName() + " = (float)(((" + printFunctionBody(msg1) + ") * (can." +
                            msg.getMessageName().toUpperCase() + "_" + msg1.getFieldName().toUpperCase() +
                            "_FACTOR)) + (can." + msg.printMsgIDName().toUpperCase() + "_" +
                            msg1.getFieldName().toUpperCase() + "_OFFSET));";

                    sourceFile_SignalConverter.append(data + "\n");
                } else if (msg1.getLengthBit() <= 16) {

                    data = "messages." + msg1.getFieldName() + " = (float)(((" + printFunctionBody(msg1) + ") * (can." +
                            msg.getMessageName().toUpperCase() + "_" + msg1.getFieldName().toUpperCase() +
                            "_FACTOR)) + (can." + msg.printMsgIDName().toUpperCase() + "_" +
                            msg1.getFieldName().toUpperCase() + "_OFFSET));";
                    sourceFile_SignalConverter.append(data + "\n");
                    
                } else if (msg1.getLengthBit() <= 32) {

                    data = "messages." + msg1.getFieldName() + " = (float)(((" + printFunctionBody(msg1) + ") * (can." +
                            msg.getMessageName().toUpperCase() + "_" + msg1.getFieldName().toUpperCase() +
                            "_FACTOR)) + (can." + msg.printMsgIDName().toUpperCase() + "_" +
                            msg1.getFieldName().toUpperCase() + "_OFFSET));";
                    sourceFile_SignalConverter.append(data + "\n");
                } else {
                	
                    data = "messages." + msg1.getFieldName() + " = (double)(((" + printFunctionBody(msg1) + ") * (can." +
                            msg.getMessageName().toUpperCase() + "_" + msg1.getFieldName().toUpperCase() +
                            "_FACTOR)) + (can." + msg.printMsgIDName().toUpperCase() + "_" +
                            msg1.getFieldName().toUpperCase() + "_OFFSET));";
                    sourceFile_SignalConverter.append(data + "\n");
                }

                validity_Count += (int) msg1.getLengthBit();
                startBit += (int) msg1.getLengthBit();

            }
            sourceFile_SignalConverter.append("\n");
            sourceFile_SignalConverter.append("  return can.").append(msg.getMessageName().toUpperCase()).append("_ID;\n");
            sourceFile_SignalConverter.append("}\n");
            sourceFile_SignalConverter.append("\n");

            sourceFile_SignalConverter.append("/*------------------------------------------------------------*/\n");
            sourceFile_SignalConverter.append("\n");
            sourceFile_SignalConverter.append("public long Serialize_" + msg.getMessageName() + "( " + incName + "_ConverterInitialize." + msg.getMessageName()
                    + "_t" + " messages, byte[] data)\n");
            sourceFile_SignalConverter.append("{\n");
            sourceFile_SignalConverter.append(" " + incName + "_ConverterInitialize can = new " + incName + "_ConverterInitialize();\n");
            for (SignalBitsDesc msg1 : msg.getSignals()) {
                if (msg1.getLengthBit() <= 8) {
                	sourceFile_SignalConverter.append("messages.").append(msg1.getFieldName())
                            .append("=(float) (" + "messages." + msg1.getFieldName() + " - can.")
                            .append(msg.printMsgIDName().toUpperCase()).append("_")
                            .append(msg1.getFieldName().toUpperCase()).append("_OFFSET);\n");
                } else if (msg1.getLengthBit() <= 16) {
                	sourceFile_SignalConverter.append("messages.").append(msg1.getFieldName())
                            .append("=(float) (" + "messages." + msg1.getFieldName() + " - can.")
                            .append(msg.printMsgIDName().toUpperCase()).append("_")
                            .append(msg1.getFieldName().toUpperCase()).append("_OFFSET);\n");
                } else if (msg1.getLengthBit() <= 32) {
                	sourceFile_SignalConverter.append("messages.").append(msg1.getFieldName())
                            .append("=(float) (" + "messages." + msg1.getFieldName() + " - can.")
                            .append(msg.printMsgIDName().toUpperCase()).append("_")
                            .append(msg1.getFieldName().toUpperCase()).append("_OFFSET);\n");
                } else {
                	sourceFile_SignalConverter.append("messages.").append(msg1.getFieldName())
                            .append("=(double) (" + "messages." + msg1.getFieldName() + " - can.")
                            .append(msg.printMsgIDName().toUpperCase()).append("_")
                            .append(msg1.getFieldName().toUpperCase()).append("_OFFSET);\n");
                }

                validity_Count += (int) msg1.getLengthBit();
                startBit += (int) msg1.getLengthBit();

                for (int i = 0; i < 8; i++) {
                    if (msg1.getSigToByte()[i] == null) {
                        continue;
                    }
                    if (msg.getSigsToByteExpr()[i] == null) {
                        msg.setSigsToByteExpr(i, String.valueOf(msg1.getSigToByte()[i]));
                    } else {
                        msg.setSigsToByteExpr(i, msg.getSigsToByteExpr()[i] + " | " + msg1.getSigToByte()[i]);
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                if (msg.getSigsToByteExpr()[i] != null) {
                    data = " data[" + i + "] = (byte)(" + msg.getSigsToByteExpr()[i] + ");\n";
                    sourceFile_SignalConverter.append(data);
                }
            }

            sourceFile_SignalConverter.append("  return can.").append(msg.getMessageName().toUpperCase()).append("_ID;\n");
            sourceFile_SignalConverter.append("}\n");
            sourceFile_SignalConverter.append("\n");
            sourceFile_SignalConverter.append("/*------------------------------------------------------------*/\n");
            sourceFile_SignalConverter.append("\n");
        }

        sourceFile_SignalConverter.append("}\n");
//
//        sourceFile.append("class " + incName + "{\n");
//        sourceFile.append("public static void main(String[] args) {\n");
//        sourceFile.append("can_Converter canconvert = new Converter();\n");
//        sourceFile.append("\n");
//        for (MessageDescriptor msg : d.getMessages()) {
//            sourceFile.append("byte[] data_deserialize_" + msg.getMessageName() + " = new byte[255];\n");
//            sourceFile.append("CanConverter." + msg.getMessageName() + "_t vcuMessages_deserialize_"
//                    + msg.getMessageName().toLowerCase() + " = new CanConverter." + msg.getMessageName() + "_t();\n");
//            sourceFile.append("canconvert.Deserialize_" + msg.getMessageName() + "(" + " vcuMessages_deserialize_"
//                    + msg.getMessageName().toLowerCase() + ", data_deserialize_" + msg.getMessageName() + ");\n");
//            sourceFile.append("\n");
//
//            sourceFile.append("byte[] data_serialize_" + msg.getMessageName() + " = new byte[255];\n");
//            sourceFile.append("CanConverter." + msg.getMessageName() + "_t vcuMessages_serialize_"
//                    + msg.getMessageName().toLowerCase() + " = new CanConverter." + msg.getMessageName() + "_t();\n");
//            sourceFile.append("canconvert.Serialize_" + msg.getMessageName() + "(" + " vcuMessages_serialize_"
//                    + msg.getMessageName().toLowerCase() + ", data_serialize_" + msg.getMessageName() + ");\n");
//            sourceFile.append("\n");
//        }
//
//        sourceFile.append("}\n");
//        sourceFile.append("}\n");

        String fileWriteSignalConverter = "";

        for (int i = 0; i < strList.length - 1; i++) {
        	fileWriteSignalConverter += strList[i] + "\\\\";
        }

        fileWriteSignalConverter = fileWriteSignalConverter + strList[strList.length - 1] + "_SignalConverter.java";
        
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWriteSignalConverter))) {
            bufferedWriter.write(sourceFile_SignalConverter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Operation successfull and Saved in the path " + fileWriteSignalConverter, "Completed",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public int shiftByte(SignalBitsDesc sg, int bn) {
        return sg.getOrder() == BitLayout.Intel ? (bn - 1) : (bn + 1);
    }

    int processSelectedIndex(int index) {
        return index;
    }


    public String printFunctionBody(SignalBitsDesc sig) {
        sb.setLength(0);
        int startb = (short) ((Controller_Endianness == (int) BitLayout.Intel.ordinal())
                ? (sig.getStartBit() + (sig.getLengthBit() - 1))
                : sig.getStartBit());
        int i = 0;
        if (startb > 63) {
            startb = 63;
        }
        int bn = startb / 8;
        int bbc = (startb % 8) + 1;
        int l = sig.getLengthBit();
        sb.setLength(0);

        if (bbc > l) {
            sb.append("((data[" + bn + "] >> can." + sig.getMaskValueToString()[i] + ") & (can." + readMask[l] + "))");
            i++;
        } else if (bbc == l) {
            sb.append("(data[" + bn + "] & (can." + readMask[l] + "))");
        } else {
            String type64 = "";
            l -= bbc;
            if (l > 31) {
                type64 = "(long)";
            }
            sb.append("(").append(type64).append("( data[").append(bn).append("] & (can.").append(readMask[bbc])
                    .append(")) << can.").append(sig.getMaskValueToString()[i]).append(")");
            i++;

            while ((l - 8) >= 0) {
                type64 = "";
                l -= 8;
                bn = shiftByte(sig, bn);
                sb.append(" | ");

                if (l == 0) {
                    sb.append("( data[" + bn + "] & (can." + readMask[8] + "))");
                } else {
                    if (l > 31) {
                        type64 = "(long)";
                    }
                    sb.append("(").append(type64).append("( data[").append(bn).append("] & (can.").append(readMask[8])
                            .append(")) << can.").append(sig.getMaskValueToString()[i]).append(")");
                    i++;
                }
            }

            if (l > 0) {
                bn = shiftByte(sig, bn);
                sb.append(" | (( data[").append(bn).append("] >> can.").append(sig.getMaskValueToString()[i])
                        .append(") & (can.").append(readMask[l]).append("))");
                i++;
            }
        }

        i = 0;
        if (startb > 63)
            startb = 63;

        bn = startb / 8;
        bbc = (startb % 8) + 1;
        l = sig.getLengthBit();
        if (bbc > l) {
            sig.getSigToByte()[bn] = "(((byte)messages." + sig.getFieldName() + " & ( can." + readMask[l] + ")) << can."
                    + sig.getMaskValueToString()[i] + ")";
            i++;
        } else if (bbc == l) {
            sig.getSigToByte()[bn] = "((byte)messages." + sig.getFieldName() + " & ( can." + readMask[l] + "))";
        } else {
            String type64 = "";
            l -= bbc;
            if (l > 31) {
                type64 = "(long)";
            }
            sig.getSigToByte()[bn] = "(((byte)messages." + sig.getFieldName() + " >> can." + sig.getMaskValueToString()[i]
                    + ") & (can." + readMask[bbc] + "))";
            i++;

            while ((l - 8) >= 0) {
                type64 = "";
                l -= 8;
                bn = shiftByte(sig, bn);

                if (l == 0) {
                    sig.getSigToByte()[bn] = "((byte)messages." + sig.getFieldName() + " & (can." + readMask[8] + "))";
                } else {
                    if (l > 31) {
                        type64 = "(long)";
                    }
                    sig.getSigToByte()[bn] = "(((byte)messages." + sig.getFieldName() + " >> can."
                            + sig.getMaskValueToString()[i] + ") & (can." + readMask[8] + "))";
                    i++;
                }
            }
            if (l > 0) {
                bn = shiftByte(sig, bn);
                sig.getSigToByte()[bn] = "(((byte)messages." + sig.getFieldName() + " & (can." + readMask[l] + ")) << can."
                        + sig.getMaskValueToString()[i] + ")";
                i++;
            }
        }
        return sb.toString();
    }

    private String update_Mask(SignalBitsDesc sig) {
        sb.setLength(0);
        short startb = (short) ((sig.getOrder() == BitLayout.Intel) ? (sig.getStartBit() + (sig.getLengthBit() - 1))
                : sig.getStartBit());

        int i = 0;
        if (startb > 63) {
            startb = 63;
        }
        int bn = startb / 8;
        int bbc = (startb % 8) + 1;
        int l = sig.getLengthBit();
        sb.setLength(0);

        if (bbc > l) {
            sig.getMaskValue()[i++] = bbc - l;
            sb.append("((data[").append(bn).append("] >> ").append(bbc - l).append(") & (").append(readMask[l])
                    .append("))");
            sig.getSigToByte()[bn] = "(((byte)messages." + sig.getFieldName() + " & (can." + readMask[l] + ")) << can."
                    + (bbc - l) + ")";
        } else if (bbc == l) {
            sb.append("(data[").append(bn).append("] & ( ").append(readMask[l]).append("))");
            sig.getSigToByte()[bn] = "((byte)messages." + sig.getFieldName() + " & (can." + readMask[l] + "))";
        } else {
            String type64_cov = "";
            l -= bbc;
            sig.getMaskValue()[i++] = l;
            if (l > 31) {
                type64_cov = "";
            }
            sb.append("(").append(type64_cov).append("(data[").append(bn).append("] & (can.").append(readMask[bbc])
                    .append(")) <<").append(l).append(")");
            sig.getSigToByte()[bn] = "(((byte)message." + sig.getFieldName() + " >> can." + l + ") & (can." + readMask[bbc]
                    + "))";

            while ((l - 8) >= 0) {
                type64_cov = "";
                l -= 8;
                bn = shiftByte(sig, bn);
                sb.append(" | ");

                if (l == 0) {
                    sb.append("(data[").append(bn).append("] & (can.").append(readMask[8]).append("))");
                    sig.getSigToByte()[bn] = "((byte)messages." + sig.getFieldName() + ") & (" + readMask[8] + "))";
                } else {
                    if (l > 31) {
                        type64_cov = "";
                    }
                    sig.getMaskValue()[i++] = l;
                    sb.append("(").append(type64_cov).append("(data[").append(bn).append("] & (can.")
                            .append(readMask[8]).append(")) <<").append(l).append(")");
                    sig.getSigToByte()[bn] = "(((byte)messages." + sig.getFieldName() + " >> " + l + ") & (can."
                            + readMask[8] + "))";
                }
            }
            if (l > 0) {
                bn = shiftByte(sig, bn);
                sb.append(" | ((data[").append(bn).append("] >> ").append(8 - l).append(") & (can.").append(readMask[l])
                        .append("))");
                sig.getSigToByte()[bn] = "(((byte)messages." + sig.getFieldName() + ") & (can." + readMask[l] + "))"
                        + ")) << " + (8 - l) + ")";
                sig.getMaskValue()[i++] = 8 - l;
            }
        }
        return sb.toString();
    }

    FileSectionPrinter headContent = new FileSectionPrinter();

    public void PrintHeadTypedef(MessageDescriptor msg) {
        headContent.body
                .append("/* public final int" + msg.getMessageName() + " CAN Message = " + msg.getMessageId() + ";\n");
        headContent.body.append("public final int" + msg.getMessageName() + "_IDE = " + msg.getIsExtended() + ";\n");
        headContent.body.append("public final int" + msg.getMessageName() + "_DLC = " + msg.getDataLen() + ";\n");
        headContent.body.append("public final int" + msg.printMsgIDName() + " = " + msg.printMsgIDValue() + ";\n");

        headContent.body.append("\n");
    }

}
