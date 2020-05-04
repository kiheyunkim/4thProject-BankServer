package com.kiheyunkim.bank.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kiheyunkim.bank.user.model.UserModel;

public class UserDaoImp implements UserDao {

	private final SessionFactory sessionFactory;
	
	public UserDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void AddUser(UserModel user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}

	@Override
	public void deleteUser(String identifyStr) {
		
		
	}

	@Override
	public UserModel findUser(String identifyStr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyUserInfo(String identifyStr, String phone, String email) {
		// TODO Auto-generated method stub
		
	}

}
