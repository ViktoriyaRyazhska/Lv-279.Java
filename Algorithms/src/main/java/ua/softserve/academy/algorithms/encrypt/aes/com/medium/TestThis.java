/*
* TestThis
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.encrypt.aes.com.medium;

public class TestThis {

    public static void main(String[] args) throws Exception {
        Encryption en = new Encryption();
        String encryptedWord = en.encrypt("Test");
        System.out.println("Encrypted word is : " + encryptedWord);
        Decryption de = new Decryption();
        System.out.println("Decrypted word is : " + de.decrypt(encryptedWord));
    }

}
