package com.kiheyunkim.bank.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ACCOUNT")
public class AccountModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(1)
	@Max(100000000)
	@Column(name = "accountNum",nullable = false, unique = true)
	private long accountNum;

	@Column(name = "password", nullable = false, length = 4)
	private String password;
	
	@Column(name = "accountType",nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private AccountType accountType;
	
	@Column(name = "balance", nullable = false)
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
