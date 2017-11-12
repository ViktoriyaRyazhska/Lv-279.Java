/*
* AESParams
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.encrypt.aes;

public class AESParams {

    public static final String key = "FFkLRp9PlF7UWl5UvaVs4MF1o6VQZktO";
    public static final String src = "Hello this is my string for encrypting.";
    public static final String fromDB1 = "eyJpdiI6IjdqY0pMZ1hBQUx5ek1QOHRMdVArS0E9PSIsInZhbHVlIjoiM3M4UWt6czZmclwveUIyaXM1ZXdmTHhzU2JhbmhTNTlJUlJMYVhOVm9sRkU9IiwibWFjIjoiYjA0MzhmZWJlZWYxMGQwMmFiMmE5NjdiM2JhOWZhMTZmNWNiMzQ0OWY1ODExMTFmNDI0YTEyOTFjZmEyYWNkZCJ9";
    public static final String fromDB2 = "eyJpdiI6InVUVVpxU1BMNXgyWHV2Skp5b3VZTFE9PSIsInZhbHVlIjoiWEgrUzBxMnI4OG9hcExTTUhzWWpOXC8wOUNxWFBFNGl1VFoxMUNFY21kZTg9IiwibWFjIjoiZmZiNWU2NDNmMGRlZDcwMTk4NmE1ZWIzNDEwMDVmYjE5NWEzZGJkYzRkMjkwYTE0YWEyMDg3YmI2YWMwMTU4MCJ9";
    public static final String fromDB3 = "eyJpdiI6InhlRWEySmJ1Nkh5VkdHRVVURFBJTmc9PSIsInZhbHVlIjoiNkJqWkN2S2h4R2QydkFrV09nanZXRG5BaFVIdUk3NGtVOVNlb2RScnQyaSsxZFJ1SnNKaDB6WGRtMk5qRDVHZCIsIm1hYyI6ImNlNzE3YTlkYTFhZDZmNzMwZDJjYmZjNDQ0NzMyZTM2Y2NmZWY2YWU1MWNmZTFlYjNjNDQ1ODQxZjkzYzY3YTEifQ==";
    public static final String fromDB4 = "eyJpdiI6IjJWeGFPM1Q0QmhYZG1EK1dYV2NPQVE9PSIsInZhbHVlIjoiWHM1eHMxTnVPdXlHcWVacGgrUlFQTEgyWDlEYjJRMlVIVGVIajlxUVI0MD0iLCJtYWMiOiI4YzNjYzhlNDVmOWZhYTVlZjJhZDYwNDBhYWEyZDE2ZTliNmU4ODkxNWEyMTdmYzBiZmI4MTg1Y2IzOWY4YzllIn0=";
    public static final String fromDB5 = "eyJpdiI6Ik5WXC83WHF4a2VDcnpZRjU1OEF0TVBRPT0iLCJ2YWx1ZSI6ImFNVk1mRjRNenArekVhdG1rXC9pZU92NmwyeTZMYmx1VUp2djlKTGRCeGRvPSIsIm1hYyI6IjFjZTM1ZTMyMzY0YTI5MWFlYjk2NzlmYWY1YTY0MGFkYzQwZmMxNGQ5OTY4MWQ3N2RmZjJhZjE5ZTk4ZTM2YTYifQ==";

    public static void printBytesAsString(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print((char) b);
        }
        System.out.println();
    }

    public static void printBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static String bytesToHex(byte[] data) {
        if (data == null) {
            return null;
        }

        int len = data.length;
        String str = "";
        for (int i = 0; i < len; i++) {
            if ((data[i] & 0xFF) < 16)
                str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
            else
                str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
        }
        return str;
    }


    public static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            byte[] buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
            }
            return buffer;
        }
    }


    public static String padString(String source) {
        char paddingChar = ' ';
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;

        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }

        return source;
    }

}
}
