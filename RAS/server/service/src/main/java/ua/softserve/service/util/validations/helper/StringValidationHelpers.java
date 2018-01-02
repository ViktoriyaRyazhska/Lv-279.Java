package ua.softserve.service.util.validations.helper;


import ua.softserve.service.util.validations.SimpleValidation;
import ua.softserve.service.util.validations.Validation;

import java.util.Objects;

import static java.lang.String.format;

public class StringValidationHelpers {
	public static Validation<String> notNull = SimpleValidation.from(Objects::nonNull, "can't be null.");

	public static Validation<String> notEmpty = SimpleValidation.from((s) -> !s.isEmpty(), "can't be empty.");

	public static Validation<String> moreThan(int size){
		return SimpleValidation.from((s) -> s.length() >= size, format("must have more than %s chars.", size));
	}
	
	public static Validation<String> lessThan(int size){
		return SimpleValidation.from((s) -> s.length() <= size, format("must have less than %s chars.", size));
	}

}
