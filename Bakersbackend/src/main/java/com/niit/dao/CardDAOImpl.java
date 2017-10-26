package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Card;

@Repository
public class CardDAOImpl implements CardDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public CardDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	
	@Transactional
	public boolean saveCard(Card card) 
	{	
		sessionFactory.getCurrentSession().saveOrUpdate(card);
		
		return true;
	}

}