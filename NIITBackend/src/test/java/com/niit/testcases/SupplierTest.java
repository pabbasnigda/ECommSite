package com.niit.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;


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
		supplier.setSupName("Chocolate Hut");
		boolean flag=supplierDAO.createSupplier(supplier);
		assertEquals("createSupplierTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void updateSupplier()
	{
		Supplier supplier = new Supplier();
		boolean flag=supplierDAO.updateSupplier(supplier);
		assertEquals("createSupplierTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void deleteSupplier()
	{
		boolean flag=supplierDAO.deleteSupplier(142);
		assertEquals("createSupplierTestCase", true, flag);
	}
	
}


