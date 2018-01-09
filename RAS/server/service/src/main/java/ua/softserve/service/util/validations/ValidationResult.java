package ua.softserve.service.util.validations;


import ua.softserve.service.exception.DataException;
import ua.softserve.service.exception.TimeFrameException;

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
		if(!isValid()) throw new DataException(getMesssage());
	}

	public void throwIfInvalidData(String fieldName) {
		if(!isValid()) throw new DataException(fieldName + " : " + getMesssage());
	}

	public void throwIfInvalidTimeFrameException() throws TimeFrameException {
		if(!isValid()) throw new TimeFrameException(getMesssage());
	}
	
	public String getMesssage() {
		return messsage;
	}
}
