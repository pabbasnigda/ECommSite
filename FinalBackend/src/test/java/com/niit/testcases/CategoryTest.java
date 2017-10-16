/*package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class CategoryTest 
{
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
	
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	
	
	@Test
	public void saveCategory()
	{
		Category category=new Category();
		category.setCategory_Name("Cadbury");
		category.setCategory_Description("dairy milk chocolates");
		boolean flag=categoryDAO.saveCategory(category);
		assertEquals("createCategoryTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateCategory()
	{
		Category category=new Category();
		//boolean flag=categoryDAO.getCategoryById(23);
		//assertEquals("createCategoryTestCase", true, flag);
	}

	@Ignore
	@Test
	public void getAllCategoryList()
	{
		Category category=new Category();
		//boolean flag=categoryDAO.getAllCategoryList();
		assertNotNull("problrm in getting category by Cid", category);
	}
}
*/