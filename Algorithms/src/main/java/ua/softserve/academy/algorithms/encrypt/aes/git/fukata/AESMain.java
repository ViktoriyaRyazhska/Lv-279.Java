/*
* AESMain
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.encrypt.aes.git.fukata;

import ua.softserve.academy.algorithms.encrypt.aes.AESParams;

public class AESMain {

    public static void main(String[] args) {
        String src = AESParams.src;
        String encrypted = AESUtil.encrypt(src);
        String decrypted = AESUtil.decrypt(AESParams.fromDB2);
        System.out.println("src: " + src);
        System.out.println("encrypted: " + encrypted);
        System.out.println("decrypted: " + decrypted);
    }

}
