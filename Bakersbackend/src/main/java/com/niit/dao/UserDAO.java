package com.niit.dao;

import java.util.List;

import com.niit.model.User;



public interface UserDAO 
{	
	public boolean saveUser(User user);
	public List<User> list();
	  public List<User> getUserById(int userid);
	  public void removeUserById(int user_id);
	  public User gtUser(int userid);
	  public List getAllUser();
	  public User get(String email);
	  
}