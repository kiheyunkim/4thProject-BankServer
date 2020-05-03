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
	public LoginModel getUser(String userId) {
		Session session = sessionFactory.getCurrentSession();
		LoginModel loginModel = session.get(LoginModel.class, userId);
		
		return loginModel;
	}
	
	@Override
	public LoginModel addUser(String id, String pw, String salt) {
		Session session = sessionFactory.getCurrentSession();
		LoginModel loginModel = new LoginModel(id, pw, salt);
		session.persist(loginModel);
		
		return loginModel;
	}

	@Override
	public LoginModel modifyPassword(String userId, String prevPassword, String newPw, String salt) {
		Session session = sessionFactory.getCurrentSession();
		LoginModel loginModel = new LoginModel(userId, prevPassword, salt);
		session.update(loginModel);

		return loginModel;
	}
}

/*
	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	CriteriaQuery<LoginModel> criteriaQuery = criteriaBuilder.createQuery(LoginModel.class);
	Root<LoginModel> root = criteriaQuery.from(LoginModel.class);
	
	criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("userId"), id));
 */


