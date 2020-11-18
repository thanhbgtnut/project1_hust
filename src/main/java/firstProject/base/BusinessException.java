package firstProject.base;


public class BusinessException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    private final BaseErrorCode code;

    private Object[] args;

    public BusinessException(BaseErrorCode code) {
        super();
        this.code = code;
    }

    public BusinessException(BaseErrorCode code, Object[] args) {
        super();
        this.code = code;
        this.args = args;
    }

    public BusinessException(String message, Throwable cause, BaseErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(String message, BaseErrorCode code) {
        super(message);
        this.code = code;
    }

    public BusinessException(Throwable cause, BaseErrorCode code) {
        super(cause);
        this.code = code;
    }

    public BaseErrorCode getCode() {
        return this.code;
    }

    public Object[] getArgs() {
        return args;
    }
}
