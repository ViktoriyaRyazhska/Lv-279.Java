package ua.softserve.service.util.validations.helper;


import ua.softserve.service.util.validations.SimpleValidation;
import ua.softserve.service.util.validations.Validation;

import static java.lang.String.format;

public class IntegerValidationHelpers {
	
	public static Validation<Integer> lowerThan(int max){
		return SimpleValidation.from((i) -> i <= max, format("must be lower than %s.", max));
	}
	
	public static Validation<Integer> greaterThan(int min){
		return SimpleValidation.from((i) -> i >= min, format("must be greater than %s.", min));
	}

}
