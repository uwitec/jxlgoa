package com.wuxianedu.domain;


import org.hibernate.validator.constraints.NotEmpty;

public class Administrator {
	
	private int id;
	@NotEmpty(message="�û�������Ϊ��")
	private String username;
	@NotEmpty(message="���벻��Ϊ��")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Administrator(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Administrator() {
		super();
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", username=" + username
				+ ", password=" + password + "]";
	}
}
