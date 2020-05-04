package com.kiheyunkim.bank.account.service;


import org.hibernate.HibernateException;

import com.kiheyunkim.bank.error.ErrorEnum;

public interface AccountService {
	public void addAccount() throws HibernateException;
	public void addAccointWithMoney(int money) throws HibernateException;
	public ErrorEnum withdraw(long accountNum, int money) throws HibernateException;
	public ErrorEnum deposit(long accountNum, int money) throws HibernateException;
	public ErrorEnum deleteAccount(long accountNum) throws HibernateException;
	public long getBalance(long accountNum) throws HibernateException;
}
