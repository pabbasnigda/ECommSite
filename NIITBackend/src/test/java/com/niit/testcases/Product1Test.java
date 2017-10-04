package com.niit.testcases;

import static org.junit.Assert.*;

import java.util.List;

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
	public void addProduct()
	{
		Product1 product=new Product1();
		productDAO.addProduct(product);
		product.setName("Milky bar");
		product.setPrice(9087.89);
		product.setQuantity(9);
		product.setP_category("Ecliars");
		
		boolean flag=productDAO.saveProduct1(product);
		
		assertEquals("createProductTestCase", true, flag);
	}
	
	
	
	
	/*public void getAllProducts()
	{
		//List<Product1> Product1 = productDAO.getAllProducts();
		//assertEquals(16,productDAO);
		
	}*/
	
	
	
	
	/*public void deleteProduct1()
	{
		productDAO.deleteProduct1(45);
		
		//boolean flag=productDAO.deleteProduc1();
		
		//assertEquals("createProductTestCase", true, flag);		
	}*/
}