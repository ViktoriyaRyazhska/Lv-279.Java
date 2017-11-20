/*
* EncryptConverter
*
* Version 1.0-SNAPSHOT
*
* 17.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util.encrypt.aes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EncryptConverter implements AttributeConverter<String, String> {

    public String convertToDatabaseColumn(String s) {
        return Encryptor.encrypt(s,AESParams.key);
    }


    public String convertToEntityAttribute(String s) {
        return Encryptor.decrypt(s,AESParams.key);
    }
}
