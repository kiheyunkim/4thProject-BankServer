package com.kiheyunkim.bank.login.service;

import org.springframework.stereotype.Service;

import com.kiheyunkim.bank.login.dao.LoginDao;
import com.kiheyunkim.bank.login.model.LoginModel;

@Service
public class LoginService {
	
	private LoginDao loginDao;
	
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public Boolean checkLogin(String userId, String password) {
		LoginModel loginModel = loginDao.getUser(userId);	
		
		if(!loginModel.equals(null)&&loginModel.getUserId().equals(userId) && loginModel.getPassword().equals(password)) {
			return true;
		}else {
			return false;	
		}
	}
	
	
	
	
	
	
	
}
