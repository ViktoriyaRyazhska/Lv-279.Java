package ua.softserve.service.exception;

/**
 * Created by yaoun on 09.01.2018.
 */
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}
