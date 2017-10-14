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
import com.niit.dao.ProductDAO;
import com.niit.model.Product;



@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class ProductTest 
{
	@Autowired
	private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
		
		//product=(Product) context.getBean("product");
		productDAO=(ProductDAO) context.getBean("productDAO");
	
	}
	
	@Ignore
	@Test
	public void createProduct()
	{
		Product product = new Product();
		product.setName("MilkyBar");
		product.setQuantity(8);
		product.setP_category("Eclairs");
		product.setPrice(567.78);
		boolean flag=productDAO.createProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateProduct()
	{
		Product product = new Product();
		boolean flag=productDAO.updateProduct(product);
		assertEquals("createProductTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void deleteProduct()
	{
		Product product = new Product();
		boolean flag=productDAO.deleteProduct(104);
		assertEquals("createProductTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void retrieveProduct()
	{
		Product product=new Product();
		boolean listproduct=productDAO.getProduct(146);
		assertNotNull("problrm in getting product by id", product);
	}
}