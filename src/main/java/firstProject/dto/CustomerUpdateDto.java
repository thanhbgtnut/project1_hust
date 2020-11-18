package firstProject.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CustomerUpdateDto {
	
	@ApiModelProperty(required = true, example = "1")
	private Long id;
	@ApiModelProperty(example = "Nguyễn Văn Thành")
	private String name;
	@ApiModelProperty(example = "Nam")
	private String sex;
	@ApiModelProperty(example = "1994-27-10 00:00:00")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
	private Date birthDay;
	@ApiModelProperty(example = "Dong Tan - Hiep Hoa - Bac Giang")
	private String address;
	@ApiModelProperty(example = "0343999094")
	private String phone;
	
	public CustomerUpdateDto() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
