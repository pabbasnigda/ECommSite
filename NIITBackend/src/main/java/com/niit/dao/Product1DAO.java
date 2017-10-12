package com.niit.dao;


import java.util.List;

import com.niit.model.Product1;

public interface Product1DAO 
{
	public boolean createProduct1(Product1 product);
	
	public boolean getProduct(int id);
	
	public boolean addProduct1(Product1 product);
	
	public boolean updateProduct1(Product1 product);
	
	public boolean deleteProduct1(int id);
}
