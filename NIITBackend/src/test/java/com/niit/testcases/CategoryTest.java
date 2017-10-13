package com.niit.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	
	@Ignore
	@Test
	public void saveCategory()
	{
		Category category=new Category();
		category.setCatName("Parle");
		category.setCatDescription("sweet");
		boolean flag=categoryDAO.saveCategory(category);
		assertEquals("createCategoryTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateCategory()
	{
		Category category=new Category();
		boolean flag=categoryDAO.updateCategory(160);
		assertEquals("createCategoryTestCase", true, flag);
	}

	@Ignore
	@Test
	public void getAllCategoryList()
	{
		Category category=new Category();
		boolean flag=categoryDAO.getAllCategoryList();
		assertNotNull("problrm in getting category by Cid", category);
	}
}
