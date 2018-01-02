package ua.softserve.service.util.validations.helper;

import ua.softserve.service.util.validations.SimpleValidation;
import ua.softserve.service.util.validations.Validation;

import java.sql.Date;

import static java.lang.String.format;

public class DateValidationHelpers {
    public static Validation<Long> startDateLessThanEndDate(long startDate){
        return SimpleValidation.from((i) -> i > startDate, "Start date must be less than End date.");
    }
}
