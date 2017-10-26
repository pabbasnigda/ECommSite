package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;

@Repository
public class CheckOutDAOImpl implements CheckOutDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public CheckOutDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cart> getTotal(int uid) {
		
		return (List<Cart>) sessionFactory.getCurrentSession()
				.createQuery("select sum(subTotal) from Cart where userid="+uid).list();

	}

}