package com.kiheyunkim.bank.login.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class LoginModel {
	@Id
	@Column(name = "userid",nullable = false, unique = true,length = 30)
	private String userId;
	
	@Column(name="password",nullable = false, unique = false,length = 64)
	private String password;
	
	@Column(name="salt",nullable = false, unique = false,length = 64)
	private String salt;
	
	@Column(name="lastChange")
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
