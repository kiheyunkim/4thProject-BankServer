package com.kiheyunkim.bank.account.dao;

import com.kiheyunkim.bank.account.model.AccountModel;
import com.kiheyunkim.bank.account.model.AccountType;

public interface AccountDao {
	public String addAccount(String password, AccountType type) ;
	public AccountModel getAccount(long accountNum);
	public void updateAccount(AccountModel accountModel);
	public void deleteACcount(long accountNum);
}