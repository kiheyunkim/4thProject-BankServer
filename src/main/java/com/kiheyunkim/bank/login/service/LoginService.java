package com.kiheyunkim.bank.login.service;

import org.springframework.stereotype.Service;

import com.kiheyunkim.bank.login.dao.LoginDao;

@Service
public class LoginService {
	
	private LoginDao loginDao;
	
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public Boolean loginCheck(String id, String pw) {		
		return true;
	}
	
	public 
	
}
