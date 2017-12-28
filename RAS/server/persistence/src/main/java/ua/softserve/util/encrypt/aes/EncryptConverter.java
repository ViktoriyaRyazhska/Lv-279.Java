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

/**
 * Converter for encrypt and decrypt fields in Hibernate. Implements AttributeConverter.
 */
@Converter
public class EncryptConverter implements AttributeConverter<String, String> {

    /**
     * The method which will be auto invoked by Hibernate to encrypt the data when they are preparing to be saved.
     *
     * @param s
     * @return
     */
    @Override
    public String convertToDatabaseColumn(String s) {
        return Encryptor.encrypt(s, AESParams.key);
    }

    /**
     * The method which will be auto invoked by Hibernate to decrypt the data when they are preparing to be read.
     *
     * @param s
     * @return
     */
    @Override
    public String convertToEntityAttribute(String s) {
        return Encryptor.decrypt(s, AESParams.key);
    }
}
