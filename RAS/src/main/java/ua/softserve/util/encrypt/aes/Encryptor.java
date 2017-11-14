/*
* Encryptor
*
* Version 1.0-SNAPSHOT
*
* 12.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.encrypt.aes;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 */
public class Encryptor {

    public static String encrypt(String value, String key) {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        byte[] encrypted = enCrypt(valueCorrector(value), key, iv);
        byte[] ivB = Base64.encodeBase64(iv);
        byte[] val = Base64.encodeBase64(encrypted);

        String json = "{\"iv\":\""+ new String(ivB) +
                "\",\"value\":\""+ new String(val) +
                "\",\"mac\":\"asd\"}";

        return new String(Base64.encodeBase64(json.getBytes()));
    }

    public static String decrypt(String value, String key) {
        byte[] json = Base64.decodeBase64(value);
        String[] split = new String(json).split("\"");
        String val = split[7];
        String mac = split[11];
        byte[] iv = Base64.decodeBase64(split[3]);
        byte[] decrypted = deCrypt(val, key, iv);
        String s = new String(decrypted);
        int start = -1;
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':') {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                    break;
                }
            }
        }
        int len = Integer.valueOf(s.substring(start + 1, end));
        decrypted = Arrays.copyOfRange(decrypted, end+2, len+end+2);
        return new String(decrypted);
    }

    private static byte[] enCrypt(byte[] value, String key, byte[] iv) {
        byte[] res = null;
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            IvParameterSpec ivPS = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), ivPS);
            res = cipher.doFinal(value);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static byte[] deCrypt(String value, String key, byte[] iv) {
        byte[] res = null;
        byte[] val = Base64.decodeBase64(value);
        try {
            final Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            IvParameterSpec ivPS = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), ivPS);
            res = cipher.doFinal(val);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static byte[] valueCorrector(String value) {
        int len = value.getBytes().length;
        value = "s:" + len + ":\"" + value + "\";";
        len = value.getBytes().length;
        int size = 16;
        int x = len % size;
        int padLength = size - x;
        byte paddingByte = (byte)padLength;
        byte[] valueBytes = new byte[len + padLength];
        int i = 0;
        for (byte b : value.getBytes()) {
            valueBytes[i++] = b;
        }
        for (; i < padLength + len; i++) {
            valueBytes[i] = paddingByte;
        }
        return valueBytes;
    }

    public static void init(){
        try {
            if (Cipher.getMaxAllowedKeyLength("AES") < 256) {
                Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
                field.setAccessible(true);
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                field.set(null, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}