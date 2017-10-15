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
	
	private String Phone;
	private String Uaddress;
	private String UFirstname, ULastname, password;
	private boolean Enabled;
	private String role;
	
	@Email(message="please enter a valid email")
	private String Email;
	
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	
	public String getUFirstname() {
		return UFirstname;
	}
	public void setUFirstname(String uFirstname) {
		UFirstname = uFirstname;
	}
	public String getULastname() {
		return ULastname;
	}
	public void setULastname(String uLastname) {
		ULastname = uLastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
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
