package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="UserDetails")
public class UserDetails implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Uid;
	
	private int Phone;
	private String UserName, Uaddress;
	@Email(message="please enter a valid email")
	private String Email;
	
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getUaddress() {
		return Uaddress;
	}
	public void setUaddress(String uaddress) {
		Uaddress = uaddress;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
