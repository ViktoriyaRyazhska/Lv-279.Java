/*
* Some
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.encrypt.aes.notused;

import ua.softserve.academy.algorithms.encrypt.aes.AESParams;
import ua.softserve.academy.algorithms.encrypt.aes.notused.com.androidsnippets.MCrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class Some {

    public static void main(String[] args) throws Exception {

        String message = AESParams.src;
        String raw = AESParams.key;

        SecretKeySpec skey = new SecretKeySpec(raw.getBytes("UTF-8"), "AES");
        Cipher c = Cipher.getInstance("AES");

//          ENCRYPTING

        c.init(Cipher.ENCRYPT_MODE, skey);
        byte[] encrypted = c.doFinal(message.getBytes("UTF-8"));

        System.out.println(MCrypt.bytesToHex(encrypted));

//          DECRYPTING

        c.init(Cipher.DECRYPT_MODE, skey);
        byte[] decrypted = c.doFinal(MCrypt.hexToBytes("edd5704616989a827414227531f5a8fb28c23b28da1ddfe18dceee41a6781f05eb7f0d3a2bfcdd60ac698b20acd75035a2e45a9fd44f8b315f4edecc87190b5fc6444a3eb9b56fbc3efcb9a12075ffb7edd5704616989a827414227531f5a8fb28c23b28da1ddfe18dceee41a6781f05d7ab00c1cf6efbe3da0f2da402a5b624b9aca3d63f72cf4f9074bb323f4e392d"));

        for (byte b : decrypted) {
            System.out.print((char) b);
        }
    }
}