package com.kiheyunkim.bank.login.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.kiheyunkim.bank.login.model.LoginModel;

@Repository
public class LoginDaoImp implements LoginDao{
	
	private final SessionFactory sessionFactory;
	
	public LoginDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(String id, String pw) {
		Session session = sessionFactory.openSession();
		try {
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean checkLogin(String id, String pw) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renewPassword(String id, String prevPw, String newPw) {
		// TODO Auto-generated method stub
		
	}
}
