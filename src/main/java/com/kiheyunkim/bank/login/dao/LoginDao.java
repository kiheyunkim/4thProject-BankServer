package com.kiheyunkim.bank.login.dao;

import java.util.Date;

public interface LoginDao {
	public Boolean addUser(String id, String pw, String salt,Date lastChange, Boolean isVerified);
	public Boolean modifyPassword(String id, String pw, String newPw, String newSalt);
	
	public void addUser(String id, String pw, String salt);
	public Boolean checkLogin(String id, String pw);
	public void renewPassword(String id, String prevPw, String newPw);
}
