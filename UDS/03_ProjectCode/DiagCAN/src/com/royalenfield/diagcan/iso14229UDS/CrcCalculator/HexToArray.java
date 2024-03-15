package com.royalenfield.diagcan.iso14229UDS.CrcCalculator;


import android.content.Context;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HexToArray {

    private  long baseAddress = 0;
    private  long totalLength = 0;
    private  long startAddress = -1;
    private  long nextExpectedAddress = 0;

    public byte[] convertHexToByteArray(Context context, Uri hexFileUri) throws IOException {
        try (InputStream inputStream = context.getContentResolver().openInputStream(hexFileUri);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

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
            return byteArrayOutputStream.toByteArray();
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

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) charPairToByte(s.substring(i, i + 2));
        }
        return data;
    }
}

