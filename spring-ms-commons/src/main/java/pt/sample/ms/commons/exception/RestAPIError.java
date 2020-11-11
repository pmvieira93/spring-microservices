package pt.sample.ms.commons.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestAPIError {
	
	Date timestamp;
	
	Integer status;
	
	String error;
	
	String exception;
	
	String message;
	
	String path;
	
	Map<String,Object> detail;
	
	public void addDetail(String key, Object data) {
		if(this.detail == null)
			this.detail = new HashMap<String, Object>();
		this.detail.put(key, data);
	}

}
