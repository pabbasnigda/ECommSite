package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
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
	//@Autowired
	//private static Product product;
	

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
	@Test
	public void createProduct1()
	{
		Product1 product=new Product1();
		product.setName("Munch");
		product.setQuantity(8);
		product.setPrice(456.12);
		product.setP_category("dark");
		
		boolean flag=productDAO.saveProduct1(product);
		
		assertEquals("createProductTestCase", true, flag);
		
		
	}
}