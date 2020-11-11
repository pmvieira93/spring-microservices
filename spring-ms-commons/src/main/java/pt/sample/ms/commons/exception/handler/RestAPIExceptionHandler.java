package pt.sample.ms.commons.exception.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pt.sample.ms.commons.exception.APIException;
import pt.sample.ms.commons.exception.RestAPIError;

/**
 * 
 * @author pedro.vieira Following:
 *         {https://codedelay.com/exceptionhandler-spring-boot-rest-exception-handling-example/}
 *         {http://198.211.104.161/spring-rest-exception-handling-2/}
 *         {https://stackoverflow.com/questions/48508285/how-to-handle-internal-server-error-500-on-spring-rest-api}
 *         {https://www.toptal.com/java/spring-boot-rest-api-error-handling}
 *         {https://thepracticaldeveloper.com/custom-error-handling-rest-controllers-spring-boot/}
 *         {https://medium.com/@sampathsl/exception-handling-for-rest-api-with-spring-boot-c5d5ba928f5b}
 */
@RestControllerAdvice
public class RestAPIExceptionHandler {


	@ExceptionHandler(APIException.class)
	public ResponseEntity<RestAPIError> handleRuntimeException(HttpServletRequest req, HttpServletResponse res,
			APIException ex) {
		HttpStatus status = HttpStatus.resolve(ex.getStatus());
		RestAPIError error = new RestAPIError();
		error.setTimestamp(new Date());
		error.setStatus(status.value());
		error.setError(status.name());
		error.setException(ex.toString());
		error.setMessage(ex.getMessage());
		error.setPath(req.getServletPath());
		error.setDetail(ex.getDetail());

		return ResponseEntity.status(status).body(error);
	}
}
