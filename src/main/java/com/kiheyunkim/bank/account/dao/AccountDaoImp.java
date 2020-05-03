package com.kiheyunkim.bank.account.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kiheyunkim.bank.account.model.AccountModel;
import com.kiheyunkim.bank.account.model.AccountType;

public class AccountDaoImp implements AccountDao{

	private final SessionFactory sessionFactory;
	
	public AccountDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory; 
	}
	
	@Override
	public AccountModel addAccount(String password, AccountType type) {
		Session session = sessionFactory.getCurrentSession();
		AccountModel accountModel = new AccountModel(password, type);
		
		session.persist(accountModel);
		
		return accountModel;
	}

	@Override
	public AccountModel getAccount(long accountNum) {
		Session session = sessionFactory.getCurrentSession();
		AccountModel accountModel = session.get(AccountModel.class, String.format("%011d", accountNum));
		
		return accountModel;
	}

	@Override
	public void updateAccount(AccountModel accountModel) {
		Session session = sessionFactory.getCurrentSession();
		session.update(accountModel);
	}

	@Override
	public void deleteACcount(long accountNum) {
		Session session = sessionFactory.getCurrentSession();
		AccountModel find = session.find(AccountModel.class, accountNum);
		
		session.delete(find);
	}
}
