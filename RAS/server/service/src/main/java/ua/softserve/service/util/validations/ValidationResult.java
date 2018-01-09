package ua.softserve.service.util.validations;


import ua.softserve.service.exception.InvalidDataException;
import ua.softserve.service.exception.InvalidTimeFrameException;

public class ValidationResult {
	private boolean valid;
	private String messsage;
	
	public static ValidationResult ok(){
		return new ValidationResult(true, null);
	}
	
	public static ValidationResult fail(String message){
		return new ValidationResult(false, message);
	}
	
	private ValidationResult(boolean valid, String messsage) {
		this.valid = valid;
		this.messsage = messsage;
	}

	public boolean isValid() {
		return valid;
	}
	
	public void throwIfInvalidData() {
		if(!isValid()) throw new InvalidDataException(getMesssage());
	}

	public void throwIfInvalidData(String fieldName) {
		if(!isValid()) throw new InvalidDataException(fieldName + " : " + getMesssage());
	}

	public void throwIfInvalidTimeFrameException() {
		if(!isValid()) throw new InvalidTimeFrameException(getMesssage());
	}
	
	public String getMesssage() {
		return messsage;
	}
}
