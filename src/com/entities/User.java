package com.entities;

import java.util.Date;

public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String UserName;
	private String Password;
	private String Name;
	private String SurName;
	private String Role;
	private String Phone;
	private String Email;
	private Date DateOfRegistration;
	
	public User() {
	}
	
	public User(String userName, String password, String name, String surName, String role, String phone, String email,
			Date dateOfRegistration) {
		super();
		UserName = userName;
		Password = password;
		Name = name;
		SurName = surName;
		Role = role;
		Phone = phone;
		Email = email;
		DateOfRegistration = dateOfRegistration;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurName() {
		return SurName;
	}

	public void setSurName(String surName) {
		SurName = surName;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getDateOfRegistration() {
		return DateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}
	
	
	
	
}
