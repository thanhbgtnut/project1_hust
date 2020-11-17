package firstProject.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponseData<T> implements Serializable{
	private int code;
	private String message;
	private T data;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone ="GMT+7")
	private Date dataTime = new Date();
	
	public ResponseData() {
		
	}
	
	public ResponseData(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public ResponseData<T> success(T data) {
		this.code=0;
		this.data = data;
		this.message ="success";
		return this;
	}
	
	public ResponseData<T> error(T data) {
		this.code=-1;
		this.data = data;
		this.message ="error";
		return this;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
