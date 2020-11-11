package pt.sample.ms.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class APINotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8120275187388884049L;

	public APINotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public APINotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public APINotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public APINotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public APINotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
