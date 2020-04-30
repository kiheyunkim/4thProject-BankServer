package com.kiheyunkim.bank.login.dao;

public interface LoginDao {
	public void addUser(String id, String pw);
	public Boolean checkLogin(String id, String pw);
	public void renewPassword(String id, String prevPw, String newPw);
}
