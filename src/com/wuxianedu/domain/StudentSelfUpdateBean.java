package com.wuxianedu.domain;

import org.hibernate.validator.constraints.NotEmpty;


public class StudentSelfUpdateBean {
	
	@NotEmpty(message="ѧ����������Ϊ��")
	private String studentName;
	@NotEmpty(message="ѧ�����ղ���Ϊ��")
	private String birthday;
	@NotEmpty(message="ѧ���绰����Ϊ��")
	private String phone;
	@NotEmpty(message="ѧ�����벻��Ϊ��")
	private String password;
	@NotEmpty(message="ѧ���Ա���Ϊ��")
	private String gender;
	@NotEmpty(message="ѧ�����᲻��Ϊ��")
	private String nativePlace;
	private String photoAddress;
	public String getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}
	public StudentSelfUpdateBean() {
		super();
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	@Override
	public String toString() {
		return "StudentSelfUpdateBean [studentName=" + studentName
				+ ", birthday=" + birthday + ", phone=" + phone + ", password="
				+ password + ", gender=" + gender + ", nativePlace="
				+ nativePlace + "]";
	}
	


}
