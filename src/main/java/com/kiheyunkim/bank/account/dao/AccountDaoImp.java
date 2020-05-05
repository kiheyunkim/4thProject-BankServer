package com.kiheyunkim.bank.account.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kiheyunkim.bank.account.model.AccountModel;
import com.kiheyunkim.bank.account.model.AccountType;

@Repository
public class AccountDaoImp implements AccountDao{

	private final SessionFactory sessionFactory;
	
	public AccountDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory; 
	}
	
	@Override
	public String addAccount(String password, AccountType type) throws HibernateException{
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountModel accountModel = new AccountModel(password, type);		
			String accountNum = (String)session.save(accountModel);
			
			return accountNum;				
		} catch (HibernateException ex) {
			throw ex;
		}
	}

	@Override
	public AccountModel getAccount(long accountNum) throws HibernateException{
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountModel accountModel = session.get(AccountModel.class, accountNum);
			
			return accountModel;			
		} catch (HibernateException ex) {
			throw ex;
		}
	}

	@Override
	public void updateAccount(AccountModel accountModel) throws HibernateException{
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(accountModel);
			} catch (HibernateException ex) {
			throw ex;
		}
		
	}

	@Override
	public void deleteACcount(long accountNum) throws HibernateException{
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountModel find = session.get(AccountModel.class, accountNum);
			session.delete(find);			
		} catch (HibernateException ex) {
			throw ex;
		}
	}
}
