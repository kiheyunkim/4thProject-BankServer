package com.kiheyunkim.bank.login.dao;

import java.util.Date;

import com.kiheyunkim.bank.login.model.LoginModel;

public interface LoginDao {
	public LoginModel getUser(String id);
	public Boolean addUser(String id, String pw, String salt,Date lastChange, Boolean isVerified);
	public Boolean modifyPassword(String id, String pw, String newPw, String newSalt);
}
