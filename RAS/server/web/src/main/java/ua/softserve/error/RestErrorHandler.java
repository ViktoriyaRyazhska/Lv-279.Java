package ua.softserve.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.softserve.service.exception.InvalidDataException;
import ua.softserve.service.exception.InvalidTimeFrameException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(InvalidDataException invalidDataException) {
        return new ResponseEntity<String>(invalidDataException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTimeFrameException.class)
    public ResponseEntity<String> handleInvalidTimeFrameException(InvalidTimeFrameException invalidTimeFrameException) {
        return new ResponseEntity<String>(invalidTimeFrameException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>(noSuchElementException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
