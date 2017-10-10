package com.niit.dao;


import java.util.List;

import com.niit.model.Product1;

public interface Product1DAO 
{
	public boolean createProduct1(Product1 product);
	
	public boolean getProduct(int id);
	
	//public List<Product1> retrieveProduct1();
	
	public boolean updateProduct1(Product1 product);
	
	public boolean deleteProduct1(int id);
}
