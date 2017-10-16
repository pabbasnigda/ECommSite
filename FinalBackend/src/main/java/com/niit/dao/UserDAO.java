package com.niit.dao;

import com.niit.model.UserDetails;

public interface UserDAO {
	public boolean saveUserDetails(UserDetails user);
	public boolean updateUserDetails(int Uid);
	public boolean deleteUserDetails(int Uid);
	public boolean getAllUserDetails();
	
	
	public UserDetails getUserDetails(String email);
	public UserDetails getUById(int customerId);
	public boolean vaildate(String user, String password);
	public UserDetails getCustomerByUsername(String username);
	public UserDetails get(String name);

	public Object getAll();
}
