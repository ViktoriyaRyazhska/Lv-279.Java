package ua.softserve.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.softserve.service.exception.InvalidDataException;
import ua.softserve.service.exception.InvalidTimeFrameException;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(InvalidDataException invalidDataException) {
        return new ResponseEntity<String>(invalidDataException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTimeFrameException.class)
    public ResponseEntity<String> handleInvalidTimeFrameException(InvalidTimeFrameException invalidTimeFrameException) {
        return new ResponseEntity<String>(invalidTimeFrameException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
