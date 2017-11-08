/*
* Some2
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.encrypt.aes;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

import static ua.softserve.academy.algorithms.encrypt.aes.AESParams.printBytesAsString;

public class Some2 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String src = AESParams.src;
        String key = AESParams.key;

        Base64 base64 = new Base64();

        String asString = base64.encodeAsString(src.getBytes("UTF-8"));
        System.out.println(asString);

        byte[] asBytes = Base64.encodeBase64(src.getBytes("UTF-8"));
        printBytesAsString(asBytes);

        byte[] decodeFromString = base64.decode(asString);
        printBytesAsString(decodeFromString);

        byte[] decodeAsBytes = base64.decode(asBytes);
        printBytesAsString(decodeAsBytes);

        byte[] decodeBase64String = Base64.decodeBase64(AESParams.fromDB2);
        printBytesAsString(decodeBase64String);

        byte[] decodeBase64Bytes = Base64.decodeBase64(asBytes);
        printBytesAsString(decodeBase64Bytes);

        byte[] decode = base64.decode("xeEa2Jbu6HyVGGEUTDPINg==");
        printBytesAsString(decode);

        String asd = new String(decodeBase64String, "utf-8");
        System.out.println(asd);

    }

}
