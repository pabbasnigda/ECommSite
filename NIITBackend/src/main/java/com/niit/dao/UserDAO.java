package com.niit.dao;

import com.niit.model.UserDetails;

public interface UserDAO 
{
	public boolean saveUserDetails(UserDetails user);
	public boolean updateUserDetails(int Uid);
	public boolean deleteUserDetails(int Uid);
	public boolean getAllUserDetails();
}
