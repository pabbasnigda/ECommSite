package com.niit.dao;

import com.niit.model.Cart;

public interface CartDAO {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(int Cid);
	public boolean getCartitems();
}
