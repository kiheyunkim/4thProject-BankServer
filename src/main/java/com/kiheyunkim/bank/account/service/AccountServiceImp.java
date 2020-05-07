package com.kiheyunkim.bank.account.service;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.kiheyunkim.bank.account.dao.AccountDao;
import com.kiheyunkim.bank.account.model.AccountModel;
import com.kiheyunkim.bank.account.model.AccountType;
import com.kiheyunkim.bank.error.ErrorEnum;

public class AccountServiceImp implements AccountService{

	private AccountDao accountDao;
	
	public AccountServiceImp(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public void addAccount(AccountType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccointWithMoney(AccountType type, int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(rollbackFor = {DataAccessException.class})
	public ErrorEnum withdraw(long accountNum, int money) throws DataAccessException{
		
		AccountModel account =  accountDao.getAccount(accountNum);
		
		if(account == null) {
			return ErrorEnum.INVALID_ACCOUNT;
		}
		
		if(account.getBalance() - money < 0) {
			return ErrorEnum.LACK_BALANCE;
		}
		
		account.setBalance(account.getBalance() - money);
		
		try {
			accountDao.updateAccount(account);			
		} catch (DataAccessException ex) {
			throw ex;
		}
		
		return ErrorEnum.WITHDRAW_SUCCESS;
	}

	@Override
	public ErrorEnum deposit(long accountNum, int money){
		
		AccountModel account = accountDao.getAccount(accountNum);
		
		if(account == null) {
			return ErrorEnum.INVALID_ACCOUNT;
		}
		
		account.setBalance(money + account.getBalance());
		
		accountDao.updateAccount(account);
		
		return ErrorEnum.DEPOSIT_SUCCESS;
		
	}

	@Override
	public ErrorEnum deleteAccount(long accountNum){
		
		AccountModel account = accountDao.getAccount(accountNum);
		
		if(account == null) {
			return ErrorEnum.INVALID_ACCOUNT;
		}
		
		accountDao.deleteACcount(accountNum);

		return ErrorEnum.DELETE_SUCCESS;
	}

	@Override
	public long getBalance(long accountNum){
		AccountModel account = accountDao.getAccount(accountNum);
		
		if(account == null) {
			return -1;
		}
		
		return account.getBalance();
	}

}
