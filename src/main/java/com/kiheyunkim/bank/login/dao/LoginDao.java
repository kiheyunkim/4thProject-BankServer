package com.kiheyunkim.bank.login.dao;

import com.kiheyunkim.bank.login.model.LoginModel;

public interface LoginDao {
	public LoginModel getUser(String id);
	public LoginModel addUser(String id, String pw, String salt);
	public LoginModel modifyPassword(String id, String pw, String newPw, String newSalt);
}
