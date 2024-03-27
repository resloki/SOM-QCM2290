package com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader;

import android.content.Context;
import android.net.Uri;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.CrcCalculator.crc32Calculator;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class HexToBin {

    String flashingFilePath = null;


    public FirmwareProgramFile convertHexToBinary(Context context, Uri firmwareImageFileURI) throws IOException {
        long baseAddress = 0;
        long totalLength = 0;
        long startAddress = -1;
        long nextExpectedAddress = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (InputStream inputStream = context.getContentResolver().openInputStream(firmwareImageFileURI);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             OutputStream outputStream = createTempFile(context)) {

            String line;
            while ((line = reader.readLine()) != null) {

                if (!line.contains(":")) {
                    continue;
                }

                line = line.substring(1);
                String recordLengthStr = line.substring(0, 2);
                int recordLength = Integer.parseInt(recordLengthStr, 16);
                String addressStr = line.substring(2, 6);
                long address = (long) Integer.parseInt(addressStr, 16);
                String recordTypeStr = line.substring(6, 8);
                int recordType = Integer.parseInt(recordTypeStr, 16);

                switch (recordType) {
                    case 0x00: {
                        String dataStr = line.substring(8, 8 + (recordLength * 2));
                        if (startAddress == -1) {
                            startAddress = baseAddress + address;
                        }
                        byte[] dataBytes = hexStringToByteArray(dataStr);

                        for (byte byteValue : dataBytes) {
                            outputStream.write(byteValue);
                        }
                        byteArrayOutputStream.write(dataBytes);
                        nextExpectedAddress += dataBytes.length;
                        totalLength += dataBytes.length;
                        break;
                    }

                    case 0x01:
                        baseAddress = 0;
                        break;
                    case 0x02:
                        baseAddress = (charPairToByte(line.substring(9, 11)) << 8) + charPairToByte(line.substring(11, 13));
                        baseAddress <<= 4;
                        break;
                    case 0x04:
                        baseAddress = Long.parseLong(line.substring(9, 9 + (recordLength * 2)), 16) << 16;
                        break;
                }
            }
            byte[] crcInput = byteArrayOutputStream.toByteArray();
            long crcoutput = crc32Calculator.calculateCrc32(crcInput);


            return new FirmwareProgramFile(totalLength, startAddress, flashingFilePath, crcoutput);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static int charPairToByte(String s) {
        if (s == null || s.length() < 2) {
            throw new IllegalArgumentException("Input string must contain at least two characters.");
        }
        int val = 0;
        for (int i = 0; i < 2; ++i) {
            char c = Character.toLowerCase(s.charAt(i));
            val <<= 4;
            if (c >= '0' && c <= '9') {
                val |= c - '0';
            } else if (c >= 'a' && c <= 'f') {
                val |= 10 + (c - 'a');
            } else {
                throw new IllegalArgumentException("Invalid hex character");
            }
        }
        return val;
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) charPairToByte(s.substring(i, i + 2));
        }
        return data;
    }

    private OutputStream createTempFile(Context context) throws IOException {
        String fileName = Long.toString(System.currentTimeMillis());
        File tempFile = File.createTempFile(fileName + "_temp_binary", ".bin", context.getCacheDir());
        flashingFilePath = tempFile.getAbsolutePath();
        System.out.println("Temporary Program file path: " + flashingFilePath);
        return new FileOutputStream(tempFile);
    }


}
