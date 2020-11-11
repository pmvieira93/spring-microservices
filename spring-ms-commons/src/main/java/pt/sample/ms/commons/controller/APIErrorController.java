package pt.sample.ms.commons.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIErrorController.ERROR_PATH)
public class APIErrorController extends AbstractErrorController {

	static final String ERROR_PATH = "/error";

	public APIErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}

	@RequestMapping
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = this.getErrorAttributes(request,
				ErrorAttributeOptions.of(Include.MESSAGE, Include.EXCEPTION));
//        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
//        if(exception != null)
//        	body.put("message", exception);
		HttpStatus status = this.getStatus(request);
		return new ResponseEntity<>(body, status);
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return APIErrorController.ERROR_PATH;
	}

}
