package com.kiheyunkim.bank.user.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserModel {
	@Id
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumns(value = {
	})
	@Column(name ="identifyStr" , length = 64, nullable = false, unique = true)
	private String identifyStr;
	@Column(name="name", length = 10, nullable = false, unique = false)
	private String name;
	@Column(name="idNum", length = 64, nullable = false, unique = false)
	private String idNum;
	@Column(name = "birthday", length = 6,nullable = false, unique = false)
	private String birthday;
	@Column(name = "sex",length = 1,nullable = false, unique = false)
	private Character sex;
	@Column(name = "phone", length = 11, nullable = true, unique = false)
	private String phone;
	@Column(name = "email", length = 255, nullable = true, unique = false)
	private String email;
	
	public String getIdentifyStr() {
		return identifyStr;
	}
	
	public void setIdentifyStr(String identifyStr) {
		this.identifyStr = identifyStr;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Character getSex() {
		return sex;
	}
	
	public void setSex(Character sex) {
		this.sex = sex;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
