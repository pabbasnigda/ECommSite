package com.niit.dao;

import java.util.List;

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

	public Product1DAOImpl(SessionFactory sessionFactory) 
	{	
		this.sessionFactory=sessionFactory;
	}
	
	public boolean saveProduct1(Product1 product) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(product);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product1> getAllProducts() 
	{
		
		return sessionFactory.getCurrentSession().createQuery("from Product1").list();
	}
	
	@Transactional
	public void deleteProduct1(int id) 
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product1 WHERE id = "+id).executeUpdate();
		
	}

	@Transactional
	public void addProduct(Product1 product) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}
	
	

	
}

