package com.kiheyunkim.bank.login.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiheyunkim.bank.login.dao.LoginDao;
import com.kiheyunkim.bank.login.model.LoginModel;

@Service
public class LoginService {
	
	private LoginDao loginDao;
	
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Transactional
	public Boolean checkLogin(String userId, String password) {
		LoginModel loginModel = loginDao.getUser(userId);	
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return false;
		}
		
		String prevHash = loginModel.getPassword() + loginModel.getSalt();
		String postHash = null;
		try {
			postHash = new BigInteger(messageDigest.digest(prevHash.getBytes("UTF-8"))).toString(16);
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		
		if(!loginModel.equals(null) 
				&& loginModel.getUserId().equals(userId) 
				&& loginModel.getPassword().equals(postHash)) {
			return true;
		}
		
		return false;	
	}
	
	@Transactional(rollbackFor = {HibernateException.class})
	public int CheckSignUp(String userId, String password1, String password2) throws HibernateException{
		if(!password1.equals(password2)) {
			return 1;
		}
		
		if(!loginDao.getUser(userId).equals(null)) {
			return 2;
		}
		
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return 3;
		}
		
		String randString = RandomStringUtils.random((new Random()).nextInt());
		String newSalt = null;
		try {
			newSalt = new BigInteger(messageDigest.digest(randString.getBytes("UTF-8"))).toString(16);
		} catch (UnsupportedEncodingException e) {
			return 4;
		}
		
		String prevNewPasswd = password1 + newSalt;
		String postNewPasswd = null;
		try {
			postNewPasswd = new BigInteger(messageDigest.digest(prevNewPasswd.getBytes("UTF-8"))).toString(16);
		} catch (UnsupportedEncodingException e) {
			return 4;
		}
		
		return 0;
	}
}
