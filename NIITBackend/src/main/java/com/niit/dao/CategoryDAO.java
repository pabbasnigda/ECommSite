package com.niit.dao;

import com.niit.model.Category;

public interface CategoryDAO 
{
	public boolean saveCategory(Category category);
	public boolean deleteCategory(int Cid);
	public boolean getAllCategoryList();
	public boolean updateCategory(int Cid);
	public boolean getCategorybyId(int Cid);
}
