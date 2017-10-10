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

import com.niit.model.Product1;


@Repository
public class Product1DAOImpl implements Product1DAO 
{
		
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Product1DAO productDAO;
	
	public Product1DAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(Product1DAO productDAO) {
		this.productDAO = productDAO;
	}

	
	public Product1DAOImpl(SessionFactory sessionFactory) 
	{	
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean createProduct1(Product1 product) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(product);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}
	
	
	@Transactional
	public boolean updateProduct1(Product1 product) 
	{
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Product1.class,new Integer(140));
		 Product1 s=(Product1)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setPrice(678.9);  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	}
	
	@Transactional
	public boolean deleteProduct1(int id) 
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product1 WHERE id = "+id).executeUpdate();
		return true;	
	}
	
	@SuppressWarnings( "rawtypes" )
	@Transactional
	public boolean getProduct(int id) 
	{
		
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Product1 p");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Product1 p = (Product1)o;
			 System.out.println("Product id : "+p.getId());
			 System.out.println("Product Name : "+p.getName());
			 System.out.println("Product Price : "+p.getPrice());
			 System.out.println("----------------------");
		 } 

		return true;
	}
}

