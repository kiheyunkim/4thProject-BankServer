package com.kiheyunkim.bank.account.service;


import org.hibernate.HibernateException;

import com.kiheyunkim.bank.error.ErrorEnum;

public interface AccountService {
	public void addAccount();
	public void addAccointWithMoney(int money);
	public void withdraw(long accountNum, int money);
	public ErrorEnum deposit(long accountNum, int money);
	public ErrorEnum deleteAccount(long accountNum) throws HibernateException;
	public long getBalance(long accountNum);
}
