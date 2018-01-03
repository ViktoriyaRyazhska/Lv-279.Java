package ua.softserve.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.softserve.service.exception.DataException;
import ua.softserve.service.exception.TimeFrameException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataException.class)
    public ResponseEntity<String> handleInvalidDataException(DataException dataException) {
        return new ResponseEntity<String>(dataException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TimeFrameException.class)
    public ResponseEntity<String> handleInvalidTimeFrameException(TimeFrameException timeFrameException) {
        return new ResponseEntity<String>(timeFrameException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>(noSuchElementException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
