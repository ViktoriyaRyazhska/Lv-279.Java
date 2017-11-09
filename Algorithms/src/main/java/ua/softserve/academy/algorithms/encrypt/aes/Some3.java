/*
* Some3
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.encrypt.aes;

public class Some3 {

    public static void main(String[] args) throws Exception {

        String src = "Майн нейм is Ореst";
        String iv = "RandomInitVector";

        System.out.println(src);
        String encrypt = Encryptor.encrypt(src, AESParams.key, iv.getBytes());
        System.out.println(encrypt);
        String decrypt = Encryptor.decrypt(encrypt, AESParams.key);
        System.out.println(decrypt);

        String decrypt2 = Encryptor.decrypt(AESParams.fromDB1, AESParams.key);
        System.out.println(decrypt2);
        System.out.println();

        decrypt2 = Encryptor.decrypt(AESParams.fromDB2, AESParams.key);
        System.out.println(decrypt2);
        System.out.println();

        decrypt2 = Encryptor.decrypt(AESParams.fromDB3, AESParams.key);
        System.out.println(decrypt2);
        System.out.println();

        decrypt2 = Encryptor.decrypt(AESParams.fromDB4, AESParams.key);
        System.out.println(decrypt2);
        System.out.println();

        decrypt2 = Encryptor.decrypt(AESParams.fromDB5, AESParams.key);
        System.out.println(decrypt2);
        System.out.println();
    }

}
