package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.CartDAO;
import com.niit.model.Cart;

//@Ignore
@ComponentScan("com.niit")
public class CartTest {
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
	public void addCart()
	{
		Cart cart = new Cart();
		cart.setProductid(001);
		cart.setProductname("chocolate");
		cart.setPrice(99.59);
		cart.setQuantity(5);
		cart.setStatus("A");
		cart.setUsername("Bob");
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
