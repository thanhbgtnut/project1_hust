package firstProject.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import firstProject.base.BaseErrorCode;
import firstProject.base.BusinessException;
import firstProject.base.ResponseData;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	@Autowired
	private MessageSource messageSource;

	public final ResponseEntity<Object> handleAllExceptionImpl(Exception ex) {
		BaseErrorCode errorCode = BaseErrorCode.SERVER_ERROR;
		Object[] objects = null;
		try {
			//logger.error("Exception: ", ex);
			throw ex;
		} catch (BusinessException e) {
			errorCode = e.getCode();
			objects = e.getArgs();
		} catch (Exception e) {
		}
		return new ResponseEntity<>(new ResponseData<>().error(errorCode.value(),getMessage(errorCode.getMessage(), objects), objects),
									errorCode.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
																		 HttpHeaders headers, HttpStatus status,
																		 WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
																	 HttpHeaders headers, HttpStatus status,
																	 WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
																	  HttpHeaders headers, HttpStatus status,
																	  WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
															   HttpStatus status, WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
																		  HttpHeaders headers, HttpStatus status,
																		  WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
																		  HttpHeaders headers, HttpStatus status,
																		  WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
																  HttpHeaders headers, HttpStatus status,
																  WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
														HttpStatus status, WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
																  HttpHeaders headers, HttpStatus status,
																  WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
																  HttpHeaders headers, HttpStatus status,
																  WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers, HttpStatus status,
																  WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
																	 HttpHeaders headers, HttpStatus status,
																	 WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
														 WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
																   HttpStatus status, WebRequest request) {
		return handleAllExceptionImpl(ex);
	}

	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
																		HttpHeaders headers, HttpStatus status,
																		WebRequest webRequest) {
		return handleAllExceptionImpl(ex);
	}

	/**
	 * Get message by message code
	 *
	 * @param code message code
	 * @return message
	 */
	private String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}
}
