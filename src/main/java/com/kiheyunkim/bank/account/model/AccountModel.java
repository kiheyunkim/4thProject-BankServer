package com.kiheyunkim.bank.account.model;

public class AccountModel {
	private long accountNum;
	private String password;
	private AccountType accountType;
	private long balance;
	
	public AccountModel() {
	}
	
	public AccountModel(String password, AccountType type) {
		this.password = password;
		this.accountType = type;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}
}
