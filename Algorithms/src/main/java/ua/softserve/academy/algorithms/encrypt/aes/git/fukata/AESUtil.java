package orok.encrypt.aes.git.fukata;

import orok.encrypt.aes.AESParams;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;


public enum AESUtil {
    ;
    private static final String ENCRYPTION_KEY = AESParams.key;

    public static String encrypt(String src) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, makeKey());
            return Base64.encodeBytes(cipher.doFinal(src.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String src) {
        String decrypted;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, makeKey());
            decrypted = new String(cipher.doFinal(Base64.decode(src)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return decrypted;
    }

    static Key makeKey() {
        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] key = md.digest(ENCRYPTION_KEY.getBytes("UTF-8"));
            byte[] key = ENCRYPTION_KEY.getBytes("UTF-8");
            return new SecretKeySpec(key, "AES");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}