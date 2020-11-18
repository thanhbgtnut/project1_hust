package firstProject.base;

import org.springframework.http.HttpStatus;

public enum BaseErrorCode {

    SERVER_ERROR(1, "server.error", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(2, "bad.request", HttpStatus.BAD_REQUEST),
	NOT_FOUND(3, "not.found", HttpStatus.NOT_FOUND),
	NOT_FOUND_AUTH_SERVICE(4, "not.found.auth.service", HttpStatus.INTERNAL_SERVER_ERROR),
	THIRTY_SERVICE_ERROR(5, "thirty.api.error", HttpStatus.BAD_REQUEST),
	UNPROCESSABLE_ENTITY(6, "bad.request", HttpStatus.UNPROCESSABLE_ENTITY),

    REFRESH_TOKEN_EXPIRED(1000, "refresh.token.expired", HttpStatus.UNAUTHORIZED),
    REFRESH_TOKEN_NOT_EXIST(1001, "refresh.token.not.exist", HttpStatus.UNAUTHORIZED),
    REFRESH_TOKEN_REQUIRED(1002, "refresh.token.required", HttpStatus.BAD_REQUEST),
    GRANT_TYPE_NOT_SUPPORTED(1003, "grant.type.not.supported", HttpStatus.BAD_REQUEST),
    TOKEN_INVALID(1004, "token.invalid", HttpStatus.UNAUTHORIZED),
    TOKEN_EXPIRED(1005, "token.expired", HttpStatus.UNAUTHORIZED),
    ACCESS_DENIED(1006, "access.denied", HttpStatus.FORBIDDEN),
    USER_PASS_INVALID(1007, "user.pass.invalid", HttpStatus.BAD_REQUEST),
    USER_NOT_ACCEPT(1008, "user.not.accept", HttpStatus.UNAUTHORIZED),
    FILE_NOT_FIND(1009, "file.not.find", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_LOCKED(1010, "user.locked", HttpStatus.UNAUTHORIZED),
	CUSTOM_VALIDATE(2100, "custom.validate", HttpStatus.BAD_REQUEST),
	ACCOUNT_NOT_IN_OPPORTUNITY(4000, "account.not.in.opportunity", HttpStatus.CONFLICT),
	ACCOUNT_OPPORTUNITY_NOT_EXISTED(4001, "account.opportunity.not.exist", HttpStatus.NOT_FOUND),
	UPDATE_STATUS_OPPORTUNITY_FAILED(4002, "update.status.opportunity.failed", HttpStatus.BAD_REQUEST);

    private final int value;

    private final String message;

    private final HttpStatus httpStatus;

    BaseErrorCode(int value, String message, HttpStatus httpStatus) {
        this.value = value;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int value() {
        return this.value;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public static BaseErrorCode of(int code){
		for (BaseErrorCode errorCode: values()) {
			if (errorCode.value == code){
				return errorCode;
			}
		}
		return BaseErrorCode.SERVER_ERROR;
	}
}

