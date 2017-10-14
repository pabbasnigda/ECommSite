package com.niit.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void addCart()
	{
		Cart cart = new Cart();
		cart.setProductid(003);
		cart.setProductname("Cadbury");
		cart.setPrice(567.89);
		cart.setQuantity(5);
		cart.setStatus("A");
		cart.setUsername("Mike");
		boolean flag=cartDAO.addCart(cart);
		assertEquals("createCartTestCase", true, flag);
	}
	
	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void updateCart()
	{
		Cart cart = new Cart();
		boolean flag= cartDAO.updateCart(cart);
		assertTrue("problem in adding CartItem",cartDAO.updateCart(cart));
	}
}
