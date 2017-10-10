package com.niit.testcases;

import static org.junit.Assert.*;
import javax.validation.constraints.AssertTrue;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.niit.config.Dbconfig;
import com.niit.dao.Product1DAO;
import com.niit.model.Product1;



@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class Product1Test 
{
	@Autowired
	private static Product1DAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
		
		//product=(Product) context.getBean("product");
		productDAO=(Product1DAO) context.getBean("productDAO");
	
	}
	
	@Ignore
	@Test
	public void createProduct1()
	{
		Product1 product = new Product1();
		product.setName("Milkyway");
		product.setQuantity(8);
		product.setP_category("Cadbury");
		product.setPrice(678.67);
		boolean flag=productDAO.createProduct1(product);
		assertEquals("createProductTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateProduct1()
	{
		Product1 product = new Product1();
		product.setName("Snickers");
		product.setP_category("Cadbury");
		assertTrue(productDAO.updateProduct1(product));
		//boolean flag=productDAO.updateProduct1(product);
		//assertEquals("createProductTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void deleteProduct1()
	{
		Product1 product = new Product1();
		product.setName("Dairy Milk");
		product.setQuantity(2);
		product.setP_category("Cadbury");
		product.setPrice(567.78);
		boolean flag=productDAO.deleteProduct1(104);
		assertEquals("createProductTestCase", true, flag);
	}
	

	@Test
	public void retrieveProduct1()
	{
		Product1 product=new Product1();
		boolean listproduct=productDAO.getProduct(41);
		assertNotNull("problrm in getting product by id", product);
	}


}