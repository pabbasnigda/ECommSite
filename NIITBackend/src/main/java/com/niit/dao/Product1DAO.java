package com.niit.dao;


import java.util.List;

import com.niit.model.Product1;

public interface Product1DAO 
{
	public boolean saveProduct1(Product1 product);
	
	void deleteProduct1(int id);
	
	List<Product1> getAllProducts();
	
	void addProduct(Product1 product);
	
	void editProduct(Product1 product);
	
}
