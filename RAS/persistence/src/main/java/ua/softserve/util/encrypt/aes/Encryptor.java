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

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Java encryptor equivalent to encryptor from PHP framework 'Laravel'
 * Based on AES/CBC/256
 */
public class Encryptor {

    private static final int MAC_POS_IN_JSON = 11;
    private static final int VALUE_POS_IN_JSON = 7;
    private static final int IV_POS_IN_JSON = 3;
    private static final int CORRECT_JSON_LENGTH = 13;

    /**
     * Encrypts the value using key
     * @param value
     * @param key
     * @return encrypted String
     */
    public static String encrypt(String value, String key) {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        byte[] encrypted = enCrypt(serialize(value), key, iv);
        byte[] ivB = Base64.encodeBase64(iv);
        byte[] val = Base64.encodeBase64(encrypted);
        String ivStr = new String(ivB);
        String valStr = new String(val);
        String mac = hashHmac(
                (ivStr + valStr).replace("\\", "").getBytes(),
                key.getBytes());
        String json = "{\"iv\":\"" + ivStr +
                "\",\"value\":\"" + valStr +
                "\",\"mac\":\"" + mac + "\"}";
        return new String(Base64.encodeBase64(json.getBytes()));
    }

    /**
     * Decrypts the value using key
     * @param value
     * @param key
     * @return decrypted String
     * @throws IllegalArgumentException can be "Incorrect value" or "Mac validation failed"
     */
    public static String decrypt(String value, String key) throws IllegalArgumentException {
        byte[] json = Base64.decodeBase64(value);
        String[] split = new String(json).split("\"");
        if (split.length != CORRECT_JSON_LENGTH) {
            throw new IllegalArgumentException("< Incorrect value >");
        }
        String val = split[VALUE_POS_IN_JSON];
        String mac = split[MAC_POS_IN_JSON];
        if (!validMac(mac, split[IV_POS_IN_JSON], val, key)) {
            throw new IllegalArgumentException("< Mac validation failed >");
        }
        byte[] iv = Base64.decodeBase64(split[IV_POS_IN_JSON]);
        byte[] decrypted = deCrypt(val, key, iv);
        return new String(unserialize(decrypted));
    }

    /**
     * Calculates mac(hash) by value and key
     * @param value
     * @param key
     * @return hash_hmac
     */
    private static String hashHmac(byte[] value, byte[] key) {
        byte[] hash;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            hash = mac.doFinal(value);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
        return String.format("%040x", new BigInteger(1, hash));
    }

    /**
     * Validates the Mac
     * @param mac
     * @param iv
     * @param val
     * @param key
     * @return
     */
    private static boolean validMac(String mac, String iv, String val, String key) {
        String mac1 = hashHmac(
                (iv + val).replace("\\", "").getBytes(),
                key.getBytes()
        );
        return mac.equalsIgnoreCase(mac1);
    }

    /**
     * Serializes the value,
     * and add to serialized value missing bytes to length multiple 16
     * @param value
     * @return
     */
    private static byte[] serialize(String value) {
        int len = value.getBytes().length;
        value = "s:" + len + ":\"" + value + "\";";
        len = value.getBytes().length;
        int size = 16;
        int x = len % size;
        int padLength = size - x;
        byte paddingByte = (byte) padLength;
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

    /**
     * Unserializes the value, and cuts off extra bytes
     * @param serializedValue
     * @return
     */
    private static byte[] unserialize(byte[] serializedValue) {
        String s = new String(serializedValue);
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
        return Arrays.copyOfRange(serializedValue, end + 2, len + end + 2);
    }

    /**
     * Encrypt method based on Cipher AES/CBC/256
     * @param value
     * @param key
     * @param iv
     * @return encrypted value
     */
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

    /**
     * Decrypt method based on Cipher AES/CBC/256
     * @param value
     * @param key
     * @param iv
     * @return decrypted value
     */
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

    /**
     * Initial method to allow using 256-key
     */
    public static void init() {
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