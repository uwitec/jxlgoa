package com.wuxianedu.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class StudentLoginBean {
	
	@NotEmpty(message="用户名不可以为空")
	private String phone;
	@NotEmpty(message="密码不可以为空")
	private String password;
	public StudentLoginBean() {
		super();
	}
	public StudentLoginBean(String phone, String password) {
		super();
		this.phone = phone;
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
