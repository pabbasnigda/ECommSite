package com.niit.dao;

import com.niit.model.Cart;

public interface CartDAO 
{
	public boolean createCart(Cart cart);
	public boolean getCartitems();
	public boolean updateCart(Cart cart);
	public boolean deleteCart(int Cid);
}
