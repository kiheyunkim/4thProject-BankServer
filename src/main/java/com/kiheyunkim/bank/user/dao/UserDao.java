package com.kiheyunkim.bank.user.dao;

import com.kiheyunkim.bank.user.model.UserModel;

public interface UserDao {
	void AddUser(UserModel user);
	void deleteUser(String identifyStr);
	UserModel findUser(String identifyStr);
	void modifyUserInfo(String identifyStr, String phone, String email);	
}
