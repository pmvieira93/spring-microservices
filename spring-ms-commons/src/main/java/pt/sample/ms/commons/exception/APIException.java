package pt.sample.ms.commons.exception;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7781557182656741831L;
	
	Integer status;
	
	Map<String, Object> detail;

	public APIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public APIException(String message, Throwable cause) {
		super(message, cause);
	}

	public APIException(String message) {
		super(message);
	}

	public APIException(Throwable cause) {
		super(cause);
	}
	
	public APIException(String message, Integer status) {
		super(message);
		this.status = status;
	}
	
	public APIException(String message, Integer status, Map<String, Object> detail) {
		super(message);
		this.status = status;
		this.detail = detail;
	}
	
	// Getters & Setters Generated
	
}
