package com.techjava.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATION28")
public class Registration {
	@Id
private String userId;
private String password;
private String emailId;
private int age;
private String contactNo;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public Registration(String userId, String password, String emailId, int age, String contactNo) {
	super();
	this.userId = userId;
	this.password = password;
	this.emailId = emailId;
	this.age = age;
	this.contactNo = contactNo;
}
public Registration() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Registration [userId=" + userId + ", password=" + password + ", emailId=" + emailId + ", age=" + age
			+ ", contactNo=" + contactNo + "]";
}

}
