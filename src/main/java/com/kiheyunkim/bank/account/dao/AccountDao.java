package com.kiheyunkim.bank.account.dao;

import org.hibernate.HibernateException;

import com.kiheyunkim.bank.account.model.AccountModel;
import com.kiheyunkim.bank.account.model.AccountType;

public interface AccountDao {
	public String addAccount(String password, AccountType type) throws HibernateException;
	public AccountModel getAccount(long accountNum) throws IllegalArgumentException, HibernateException;
	public void updateAccount(AccountModel accountModel) throws HibernateException;
	public void deleteACcount(long accountNum) throws HibernateException;
}