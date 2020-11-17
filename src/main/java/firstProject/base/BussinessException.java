package firstProject.base;

public class BussinessException extends Exception {
	private BaseErrorCode code;
	private Object[] args;
	public BussinessException(BaseErrorCode code, Object[] args) {
		super();
		this.code = code;
		this.args = args;
	}
	
	public BussinessException(String message, Throwable cause, BaseErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public BussinessException(String message, BaseErrorCode code) {
        super(message);
        this.code = code;
    }

    public BussinessException(Throwable cause, BaseErrorCode code) {
        super(cause);
        this.code = code;
    }

	
	public BussinessException(BaseErrorCode code) {
		super();
		this.code = code;
	}
	
	public BaseErrorCode getCode() {
		return code;
	}
	public void setCode(BaseErrorCode code) {
		this.code = code;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	
	
}
