package com.niit.dao;


import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;


@Repository
public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductDAO productDAO;
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	
	public ProductDAOImpl(SessionFactory sessionFactory) 
	{	
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(product);
		org.hibernate.Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}
	@SuppressWarnings( "rawtypes" )
	@Transactional
	public boolean getProduct(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Product p");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Product p = (Product)o;
			 System.out.println("Product id : "+p.getId());
			 System.out.println("Product Name : "+p.getName());
			 System.out.println("Product Price : "+p.getPrice());
			 System.out.println("Product Quantity : "+p.getQuantity());
			 System.out.println("----------------------");
		 } 

		return true;
	}

	@Transactional
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
		return true;
	}
	@Transactional
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		 Object o=session.load(Product.class,new Integer(207));
		 Product s=(Product)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setP_category("Electronic");  
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	}

	@Transactional
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE id = "+id).executeUpdate();
		return true;
	}

	
	public boolean updateProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
