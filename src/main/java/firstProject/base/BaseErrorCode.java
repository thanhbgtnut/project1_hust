package firstProject.base;

import org.springframework.http.HttpStatus;

public enum BaseErrorCode {
	
	SERVER_ERROR(1, "server.error", HttpStatus.INTERNAL_SERVER_ERROR),
	
	//CUSTOMER MESSAGE
	CUSTOMER_NOT_FOUND(1000, "customer.not.found", HttpStatus.NOT_FOUND)
	
	;
	
	
	private HttpStatus httpStatus;
	private String message;
	private int valueError;
	BaseErrorCode(int valueError, String message, HttpStatus httpstatus){
		this.httpStatus = httpstatus;
		this.valueError =valueError;
		this.message = message;
	}
}
