/*
* newA
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.encrypt.aes.com.androidsnippets;

import ua.softserve.academy.algorithms.encrypt.aes.AESParams;

public class MCryptDemo {

    public static void main(String[] args) throws Exception {

        String message = AESParams.src;

        MCrypt mCrypt = new MCrypt();
        byte[] encrypt = mCrypt.encrypt(message);
        String hex = MCrypt.bytesToHex(encrypt);
        System.out.println(hex);
        System.out.println();
        byte[] decrypt = mCrypt.decrypt(hex);
        for (byte b : decrypt) {
            System.out.print((char)b);
        }


    }

}