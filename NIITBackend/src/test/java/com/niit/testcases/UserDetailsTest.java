package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;

import com.niit.dao.UserDAO;
import com.niit.model.UserDetails;


@ComponentScan("com.niit")
public class UserDetailsTest 
{
	@Autowired
	private static UserDAO userDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
		
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void saveUserDetails()
	{
		UserDetails user = new UserDetails();
		user.setUserName("Joseph");
		user.setUaddress("WGL");
		user.setEmail("rtc@gmail.com");
		user.setPhone(567898);
		boolean flag=userDAO.saveUserDetails(user);
		assertEquals("createUserTestCase", true, flag);
	}
	
	@Ignore
	@SuppressWarnings("unused")
	@Test
	public void getAllUserDetails()
	{
		UserDetails user = new UserDetails();
		boolean list=userDAO.getAllUserDetails();
		assertNotNull("problem in getting userdetails", user);
	}
}
