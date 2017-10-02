package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product1;


@Repository
public class Product1DAOImpl implements Product1DAO {
	
	
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

	
}

