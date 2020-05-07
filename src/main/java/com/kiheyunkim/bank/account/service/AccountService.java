package com.kiheyunkim.bank.account.service;


import com.kiheyunkim.bank.account.model.AccountType;
import com.kiheyunkim.bank.error.ErrorEnum;

public interface AccountService {
	public void addAccount(AccountType type);
	public void addAccointWithMoney(AccountType type, int money);
	public ErrorEnum withdraw(long accountNum, int money);
	public ErrorEnum deposit(long accountNum, int money);
	public ErrorEnum deleteAccount(long accountNum);
	public long getBalance(long accountNum);
}
