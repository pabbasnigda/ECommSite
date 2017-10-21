/*package com.niit.testcases;

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
	public void saveProductToCart()
	{
		Cart cart = new Cart();
		cart.setProductid(45);
		cart.setProductName("Parle");
		cart.setProductPrice(34.56);
		cart.setProductQuantity(2);
		cart.setStatus("A");
		cart.setSubTotal(234);
		cart.setUserId(34);
		boolean flag=cartDAO.saveProductToCart(cart);
		assertEquals("createCartTestCase", true, flag);
	}
}*/