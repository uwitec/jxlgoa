package com.wuxianedu.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class StudentLoginBean {
	
	@NotEmpty(message="�û���������Ϊ��")
	private String phone;
	@NotEmpty(message="���벻����Ϊ��")
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
