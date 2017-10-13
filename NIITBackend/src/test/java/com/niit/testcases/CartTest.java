package com.niit.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.CartDAO;
import com.niit.model.Cart;

@ComponentScan("com.niit")
public class CartTest 
{
	@Autowired
	private static CartDAO cartDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
		
		cartDAO=(CartDAO) context.getBean("cartDAO");
	}
	
	@Test
	public void createCart()
	{
		Cart cart = new Cart();
		cart.setCitemid(123);
		cart.setPrice(456.67);
		cart.setProductid(230);
		cart.setProductname("cadbury");
		cart.setQuantity(3);
		cart.setStatus("NA");
		cart.setUsername("Jhon");
		boolean flag=cartDAO.createCart(cart);
		assertEquals("createCartTestCase", true, flag);
	}
}
