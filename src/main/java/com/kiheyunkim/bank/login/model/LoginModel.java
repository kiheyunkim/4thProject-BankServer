package com.kiheyunkim.bank.login.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class LoginModel {
	private String userId;
	private String password;
	private String salt;
	private Date lastChange;

	public LoginModel() {
		
	}
	
	public LoginModel(String userId, String password, String salt) {
		this.userId = userId;
		this.password = password;
		this.salt = salt;
		this.lastChange = new Date(System.currentTimeMillis());
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}
}
