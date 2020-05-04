package com.kiheyunkim.bank.account.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.kiheyunkim.bank.account.model.AccountModel;
import com.kiheyunkim.bank.error.ErrorEnum;

public class AccountServiceImp implements AccountService{

	private final SessionFactory sessionFactory;
	
	public AccountServiceImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccointWithMoney(int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(rollbackFor = {HibernateException.class})
	public ErrorEnum withdraw(long accountNum, int money) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		AccountModel account = session.get(AccountModel.class, accountNum);
		
		if(account == null) {
			return ErrorEnum.INVALID_ACCOUNT;
		}
		
		if(account.getBalance() - money < 0) {
			return ErrorEnum.LACK_BALANCE;
		}
		
		account.setBalance(account.getBalance() - money);
		
		session.update(account);
		
		return ErrorEnum.WITHDRAW_SUCCESS;
	}

	@Override
	@Transactional(rollbackFor = {HibernateException.class})
	public ErrorEnum deposit(long accountNum, int money) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		AccountModel account = session.get(AccountModel.class, accountNum);
		
		if(account == null) {
			return ErrorEnum.INVALID_ACCOUNT;
		}
		
		account.setBalance(money + account.getBalance());
		
		session.update(account);
		
		return ErrorEnum.DEPOSIT_SUCCESS;
		
	}

	@Override
	@Transactional(rollbackFor = {HibernateException.class})
	public ErrorEnum deleteAccount(long accountNum) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		AccountModel account = session.get(AccountModel.class, accountNum);
		
		if(account == null) {
			return ErrorEnum.INVALID_ACCOUNT;
		}
		
		session.delete(account);

		return ErrorEnum.DELETE_SUCCESS;
	}

	@Override
	@Transactional(rollbackFor = {HibernateException.class})
	public long getBalance(long accountNum) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		AccountModel account = session.get(AccountModel.class, accountNum);
		
		if(account == null) {
			return -1;
		}
		
		return account.getBalance();
	}

}
