package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CheckOutDAO 
{
	public List<Cart> getTotal(int uid);
}