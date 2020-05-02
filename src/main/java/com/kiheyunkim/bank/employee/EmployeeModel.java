package com.kiheyunkim.bank.employee;

import javax.persistence.Column;

public class EmployeeModel {
	@Column(name = "employeeNum", unique = true, nullable = false)
	private long employeeNum;
	private String name;
	private String birthday;
	private EmployeeGrade grade;
	
	public EmployeeModel() {
	}
	
	public long getEmployeeNum() {
		return employeeNum;
	}
	
	public void setEmployeeNum(long employeeNum) {
		this.employeeNum = employeeNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public EmployeeGrade getGrade() {
		return grade;
	}
	
	public void setGrade(EmployeeGrade grade) {
		this.grade = grade;
	}
}
