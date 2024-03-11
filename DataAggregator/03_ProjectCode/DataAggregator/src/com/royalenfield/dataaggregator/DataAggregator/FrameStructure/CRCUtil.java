package com.royalenfield.dataaggregator.DataAggregator.FrameStructure;

public class CRCUtil {


    private static final int[] CRC32_LOOKUP_TABLE = new int[]{


            /* 0x00 */ 0x00000000 , 0x77073096 , 0xEE0E612C , 0x990951BA ,
            /* 0x04 */ 0x076DC419 , 0x706AF48F , 0xE963A535 , 0x9E6495A3 ,
            /* 0x08 */ 0x0EDB8832 , 0x79DCB8A4 , 0xE0D5E91E , 0x97D2D988 ,
            /* 0x0C */ 0x09B64C2B , 0x7EB17CBD , 0xE7B82D07 , 0x90BF1D91 ,
            /* 0x10 */ 0x1DB71064 , 0x6AB020F2 , 0xF3B97148 , 0x84BE41DE ,
            /* 0x14 */ 0x1ADAD47D , 0x6DDDE4EB , 0xF4D4B551 , 0x83D385C7 ,
            /* 0x18 */ 0x136C9856 , 0x646BA8C0 , 0xFD62F97A , 0x8A65C9EC ,
            /* 0x1C */ 0x14015C4F , 0x63066CD9 , 0xFA0F3D63 , 0x8D080DF5 ,
            /* 0x20 */ 0x3B6E20C8 , 0x4C69105E , 0xD56041E4 , 0xA2677172 ,
            /* 0x24 */ 0x3C03E4D1 , 0x4B04D447 , 0xD20D85FD , 0xA50AB56B ,
            /* 0x28 */ 0x35B5A8FA , 0x42B2986C , 0xDBBBC9D6 , 0xACBCF940 ,
            /* 0x2C */ 0x32D86CE3 , 0x45DF5C75 , 0xDCD60DCF , 0xABD13D59 ,
            /* 0x30 */ 0x26D930AC , 0x51DE003A , 0xC8D75180 , 0xBFD06116 ,
            /* 0x34 */ 0x21B4F4B5 , 0x56B3C423 , 0xCFBA9599 , 0xB8BDA50F ,
            /* 0x38 */ 0x2802B89E , 0x5F058808 , 0xC60CD9B2 , 0xB10BE924 ,
            /* 0x3C */ 0x2F6F7C87 , 0x58684C11 , 0xC1611DAB , 0xB6662D3D ,
            /* 0x40 */ 0x76DC4190 , 0x01DB7106 , 0x98D220BC , 0xEFD5102A ,
            /* 0x44 */ 0x71B18589 , 0x06B6B51F , 0x9FBFE4A5 , 0xE8B8D433 ,
            /* 0x48 */ 0x7807C9A2 , 0x0F00F934 , 0x9609A88E , 0xE10E9818 ,
            /* 0x4C */ 0x7F6A0DBB , 0x086D3D2D , 0x91646C97 , 0xE6635C01 ,
            /* 0x50 */ 0x6B6B51F4 , 0x1C6C6162 , 0x856530D8 , 0xF262004E ,
            /* 0x54 */ 0x6C0695ED , 0x1B01A57B , 0x8208F4C1 , 0xF50FC457 ,
            /* 0x58 */ 0x65B0D9C6 , 0x12B7E950 , 0x8BBEB8EA , 0xFCB9887C ,
            /* 0x5C */ 0x62DD1DDF , 0x15DA2D49 , 0x8CD37CF3 , 0xFBD44C65 ,
            /* 0x60 */ 0x4DB26158 , 0x3AB551CE , 0xA3BC0074 , 0xD4BB30E2 ,
            /* 0x64 */ 0x4ADFA541 , 0x3DD895D7 , 0xA4D1C46D , 0xD3D6F4FB ,
            /* 0x68 */ 0x4369E96A , 0x346ED9FC , 0xAD678846 , 0xDA60B8D0 ,
            /* 0x6C */ 0x44042D73 , 0x33031DE5 , 0xAA0A4C5F , 0xDD0D7CC9 ,
            /* 0x70 */ 0x5005713C , 0x270241AA , 0xBE0B1010 , 0xC90C2086 ,
            /* 0x74 */ 0x5768B525 , 0x206F85B3 , 0xB966D409 , 0xCE61E49F ,
            /* 0x78 */ 0x5EDEF90E , 0x29D9C998 , 0xB0D09822 , 0xC7D7A8B4 ,
            /* 0x7C */ 0x59B33D17 , 0x2EB40D81 , 0xB7BD5C3B , 0xC0BA6CAD ,
            /* 0x80 */ 0xEDB88320 , 0x9ABFB3B6 , 0x03B6E20C , 0x74B1D29A ,
            /* 0x84 */ 0xEAD54739 , 0x9DD277AF , 0x04DB2615 , 0x73DC1683 ,
            /* 0x88 */ 0xE3630B12 , 0x94643B84 , 0x0D6D6A3E , 0x7A6A5AA8 ,
            /* 0x8C */ 0xE40ECF0B , 0x9309FF9D , 0x0A00AE27 , 0x7D079EB1 ,
            /* 0x90 */ 0xF00F9344 , 0x8708A3D2 , 0x1E01F268 , 0x6906C2FE ,
            /* 0x94 */ 0xF762575D , 0x806567CB , 0x196C3671 , 0x6E6B06E7 ,
            /* 0x98 */ 0xFED41B76 , 0x89D32BE0 , 0x10DA7A5A , 0x67DD4ACC ,
            /* 0x9C */ 0xF9B9DF6F , 0x8EBEEFF9 , 0x17B7BE43 , 0x60B08ED5 ,
            /* 0xA0 */ 0xD6D6A3E8 , 0xA1D1937E , 0x38D8C2C4 , 0x4FDFF252 ,
            /* 0xA4 */ 0xD1BB67F1 , 0xA6BC5767 , 0x3FB506DD , 0x48B2364B ,
            /* 0xA8 */ 0xD80D2BDA , 0xAF0A1B4C , 0x36034AF6 , 0x41047A60 ,
            /* 0xAC */ 0xDF60EFC3 , 0xA867DF55 , 0x316E8EEF , 0x4669BE79 ,
            /* 0xB0 */ 0xCB61B38C , 0xBC66831A , 0x256FD2A0 , 0x5268E236 ,
            /* 0xB4 */ 0xCC0C7795 , 0xBB0B4703 , 0x220216B9 , 0x5505262F ,
            /* 0xB8 */ 0xC5BA3BBE , 0xB2BD0B28 , 0x2BB45A92 , 0x5CB36A04 ,
            /* 0xBC */ 0xC2D7FFA7 , 0xB5D0CF31 , 0x2CD99E8B , 0x5BDEAE1D ,
            /* 0xC0 */ 0x9B64C2B0 , 0xEC63F226 , 0x756AA39C , 0x026D930A ,
            /* 0xC4 */ 0x9C0906A9 , 0xEB0E363F , 0x72076785 , 0x05005713 ,
            /* 0xC8 */ 0x95BF4A82 , 0xE2B87A14 , 0x7BB12BAE , 0x0CB61B38 ,
            /* 0xCC */ 0x92D28E9B , 0xE5D5BE0D , 0x7CDCEFB7 , 0x0BDBDF21 ,
            /* 0xD0 */ 0x86D3D2D4 , 0xF1D4E242 , 0x68DDB3F8 , 0x1FDA836E ,
            /* 0xD4 */ 0x81BE16CD , 0xF6B9265B , 0x6FB077E1 , 0x18B74777 ,
            /* 0xD8 */ 0x88085AE6 , 0xFF0F6A70 , 0x66063BCA , 0x11010B5C ,
            /* 0xDC */ 0x8F659EFF , 0xF862AE69 , 0x616BFFD3 , 0x166CCF45 ,
            /* 0xE0 */ 0xA00AE278 , 0xD70DD2EE , 0x4E048354 , 0x3903B3C2 ,
            /* 0xE4 */ 0xA7672661 , 0xD06016F7 , 0x4969474D , 0x3E6E77DB ,
            /* 0xE8 */ 0xAED16A4A , 0xD9D65ADC , 0x40DF0B66 , 0x37D83BF0 ,
            /* 0xEC */ 0xA9BCAE53 , 0xDEBB9EC5 , 0x47B2CF7F , 0x30B5FFE9 ,
            /* 0xF0 */ 0xBDBDF21C , 0xCABAC28A , 0x53B39330 , 0x24B4A3A6 ,
            /* 0xF4 */ 0xBAD03605 , 0xCDD70693 , 0x54DE5729 , 0x23D967BF ,
            /* 0xF8 */ 0xB3667A2E , 0xC4614AB8 , 0x5D681B02 , 0x2A6F2B94 ,
            /* 0xFC */ 0xB40BBE37 , 0xC30C8EA1 , 0x5A05DF1B , 0x2D02EF8D

    };

    private static final byte[] CRC8_LOOKUP_TABLE = new byte[]{
            (byte) 0x00, (byte) 0x07, (byte) 0x0E, (byte) 0x09, (byte) 0x1C, (byte) 0x1B, (byte) 0x12, (byte) 0x15,
            (byte) 0x38, (byte) 0x3F, (byte) 0x36, (byte) 0x31, (byte) 0x24, (byte) 0x23, (byte) 0x2A, (byte) 0x2D,
            (byte) 0x70, (byte) 0x77, (byte) 0x7E, (byte) 0x79, (byte) 0x6C, (byte) 0x6B, (byte) 0x62, (byte) 0x65,
            (byte) 0x48, (byte) 0x4F, (byte) 0x46, (byte) 0x41, (byte) 0x54, (byte) 0x53, (byte) 0x5A, (byte) 0x5D,
            (byte) 0xE0, (byte) 0xE7, (byte) 0xEE, (byte) 0xE9, (byte) 0xFC, (byte) 0xFB, (byte) 0xF2, (byte) 0xF5,
            (byte) 0xD8, (byte) 0xDF, (byte) 0xD6, (byte) 0xD1, (byte) 0xC4, (byte) 0xC3, (byte) 0xCA, (byte) 0xCD,
            (byte) 0x90, (byte) 0x97, (byte) 0x9E, (byte) 0x99, (byte) 0x8C, (byte) 0x8B, (byte) 0x82, (byte) 0x85,
            (byte) 0xA8, (byte) 0xAF, (byte) 0xA6, (byte) 0xA1, (byte) 0xB4, (byte) 0xB3, (byte) 0xBA, (byte) 0xBD,
            (byte) 0xC7, (byte) 0xC0, (byte) 0xC9, (byte) 0xCE, (byte) 0xDB, (byte) 0xDC, (byte) 0xD5, (byte) 0xD2,
            (byte) 0xFF, (byte) 0xF8, (byte) 0xF1, (byte) 0xF6, (byte) 0xE3, (byte) 0xE4, (byte) 0xED, (byte) 0xEA,
            (byte) 0xB7, (byte) 0xB0, (byte) 0xB9, (byte) 0xBE, (byte) 0xAB, (byte) 0xAC, (byte) 0xA5, (byte) 0xA2,
            (byte) 0x8F, (byte) 0x88, (byte) 0x81, (byte) 0x86, (byte) 0x93, (byte) 0x94, (byte) 0x9D, (byte) 0x9A,
            (byte) 0x27, (byte) 0x20, (byte) 0x29, (byte) 0x2E, (byte) 0x3B, (byte) 0x3C, (byte) 0x35, (byte) 0x32,
            (byte) 0x1F, (byte) 0x18, (byte) 0x11, (byte) 0x16, (byte) 0x03, (byte) 0x04, (byte) 0x0D, (byte) 0x0A,
            (byte) 0x57, (byte) 0x50, (byte) 0x59, (byte) 0x5E, (byte) 0x4B, (byte) 0x4C, (byte) 0x45, (byte) 0x42,
            (byte) 0x6F, (byte) 0x68, (byte) 0x61, (byte) 0x66, (byte) 0x73, (byte) 0x74, (byte) 0x7D, (byte) 0x7A,
            (byte) 0x89, (byte) 0x8E, (byte) 0x87, (byte) 0x80, (byte) 0x95, (byte) 0x92, (byte) 0x9B, (byte) 0x9C,
            (byte) 0xB1, (byte) 0xB6, (byte) 0xBF, (byte) 0xB8, (byte) 0xAD, (byte) 0xAA, (byte) 0xA3, (byte) 0xA4,
            (byte) 0xF9, (byte) 0xFE, (byte) 0xF7, (byte) 0xF0, (byte) 0xE5, (byte) 0xE2, (byte) 0xEB, (byte) 0xEC,
            (byte) 0xC1, (byte) 0xC6, (byte) 0xCF, (byte) 0xC8, (byte) 0xDD, (byte) 0xDA, (byte) 0xD3, (byte) 0xD4,
            (byte) 0x69, (byte) 0x6E, (byte) 0x67, (byte) 0x60, (byte) 0x75, (byte) 0x72, (byte) 0x7B, (byte) 0x7C,
            (byte) 0x51, (byte) 0x56, (byte) 0x5F, (byte) 0x58, (byte) 0x4D, (byte) 0x4A, (byte) 0x43, (byte) 0x44,
            (byte) 0x19, (byte) 0x1E, (byte) 0x17, (byte) 0x10, (byte) 0x05, (byte) 0x02, (byte) 0x0B, (byte) 0x0C,
            (byte) 0x21, (byte) 0x26, (byte) 0x2F, (byte) 0x28, (byte) 0x3D, (byte) 0x3A, (byte) 0x33, (byte) 0x34,
            (byte) 0x4E, (byte) 0x49, (byte) 0x40, (byte) 0x47, (byte) 0x52, (byte) 0x55, (byte) 0x5C, (byte) 0x5B,
            (byte) 0x76, (byte) 0x71, (byte) 0x78, (byte) 0x7F, (byte) 0x6A, (byte) 0x6D, (byte) 0x64, (byte) 0x63,
            (byte) 0x3E, (byte) 0x39, (byte) 0x30, (byte) 0x37, (byte) 0x22, (byte) 0x25, (byte) 0x2C, (byte) 0x2B,
            (byte) 0x06, (byte) 0x01, (byte) 0x08, (byte) 0x0F, (byte) 0x1A, (byte) 0x1D, (byte) 0x14, (byte) 0x13,
            (byte) 0xAE, (byte) 0xA9, (byte) 0xA0, (byte) 0xA7, (byte) 0xB2, (byte) 0xB5, (byte) 0xBC, (byte) 0xBB,
            (byte) 0x96, (byte) 0x91, (byte) 0x98, (byte) 0x9F, (byte) 0x8A, (byte) 0x8D, (byte) 0x84, (byte) 0x83,
            (byte) 0xDE, (byte) 0xD9, (byte) 0xD0, (byte) 0xD7, (byte) 0xC2, (byte) 0xC5, (byte) 0xCC, (byte) 0xCB,
            (byte) 0xE6, (byte) 0xE1, (byte) 0xE8, (byte) 0xEF, (byte) 0xFA, (byte) 0xFD, (byte) 0xF4, (byte) 0xF3
    };

    public static int calculateCRC32(byte[] crcData, int crcSize, int crcLastCrc32) {
        for (int i = 0; i < crcSize; i++) {
            crcLastCrc32 = (crcLastCrc32 >>> 8) ^ CRC32_LOOKUP_TABLE[(crcLastCrc32 ^ crcData[i]) & 0xFF];
        }
        return crcLastCrc32;
    }

    public static byte calculateCRC8(byte[] crcData, int size) {
        byte crc = 0;

        for (int i = 0; i < size; i++) {
            crc = CRC8_LOOKUP_TABLE[(crc ^ crcData[i]) & 0xFF];
        }

        return crc;
    }
}
