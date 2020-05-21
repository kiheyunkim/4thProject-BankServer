package com.kiheyunkim.bank.user.model;

public class UserModel {
	private String identifyStr;
	private String name;
	private String idNum;
	private String birthday;
	private Character sex;
	private String phone;
	private String email;
	
	public String getIdentifyStr() {
		return identifyStr;
	}
	
	public void setIdentifyStr(String identifyStr) {
		this.identifyStr = identifyStr;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Character getSex() {
		return sex;
	}
	
	public void setSex(Character sex) {
		this.sex = sex;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
