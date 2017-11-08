/*
* AESParams
*
* Version 1.0-SNAPSHOT
*
* 08.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.encrypt.aes;

public class AESParams {

    public static final String key = "FFkLRp9PlF7UWl5UvaVs4MF1o6VQZktO";
    public static final String src = "Hello this is my string for encrypting.";
    public static final String fromDB2 = "6BjZCvKhxGd2vAkWOgjvWDnAhUHuI74kU9SeodRrt2i+1dRuJsJh0zXdm2NjD5Gd";
    public static final String fromDB = "eyJpdiI6InhlRWEySmJ1Nkh5VkdHRVVURFBJT" +
                                        "mc9PSIsInZhbHVlIjoiNkJqWkN2S2h4R2Qydk" +
                                        "FrV09nanZXRG5BaFVIdUk3NGtVOVNlb2RScnQ" +
                                        "yaSsxZFJ1SnNKaDB6WGRtMk5qRDVHZCIsIm1h" +
                                        "YyI6ImNlNzE3YTlkYTFhZDZmNzMwZDJjYmZjN" +
                                        "DQ0NzMyZTM2Y2NmZWY2YWU1MWNmZTFlYjNjND" +
                                        "Q1ODQxZjkzYzY3YTEifQ==";

    public static void printBytesAsString(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print((char)b);
        }
        System.out.println();
    }

}
