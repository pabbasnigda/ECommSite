package com.niit.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.Product1DAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Product1;
import com.niit.model.Supplier;



@SuppressWarnings("unused")
@ComponentScan("com.niit")
public class SupplierTest 
{
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.*");
		context.refresh();
	
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void createSupplier()
	{
		Supplier supplier = new Supplier();
		supplier.setSupName("Ayan dealers");
		boolean flag=supplierDAO.createSupplier(supplier);
		assertEquals("createProductTestCase", true, flag);
	}
	
	
	@Test
	public void updateSupplier()
	{
		Supplier supplier = new Supplier();
		boolean flag=supplierDAO.updateSupplier(supplier);
		assertEquals("createProductTestCase", true, flag);
	}
	
}


