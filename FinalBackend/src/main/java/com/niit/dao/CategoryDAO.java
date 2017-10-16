package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO 
{	
	public boolean saveCategory(Category category);

	public List<Category> list();

	public Category getCategoryById(int category_id);

	public Category removeCategoryById(int category_id);
}
