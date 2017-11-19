/*
* Some
*
* Version 1.0-SNAPSHOT
*
* 12.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.encrypt.aes;

public class EncryptorDemo {

    public static void main(String[] args) {

        Encryptor.init();

        String encrypted = Encryptor.encrypt("This is example how to use this util!", AESParams.key);
        String decrypted = Encryptor.decrypt(encrypted, AESParams.key);

        System.out.println("Encrypted value:");
        System.out.println(encrypted);
        System.out.println("Decrypted value:");
        System.out.println(decrypted);

    }

}
