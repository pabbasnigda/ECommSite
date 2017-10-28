package com.niit.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Order;
import com.niit.model.Cart;



@Repository
public class OrderDAOImpl implements OrderDAO 
{	
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	@SuppressWarnings("deprecation")
	@Transactional
	public boolean OrderDetails()
	{
		
		@SuppressWarnings("rawtypes")
		Query query =sessionFactory.getCurrentSession().createQuery("insert into Order(orderId , productid , productname ,productprice ,quantity ,status ,subTotal ,userid )" + "select orderId ,productid ,productname ,productprice ,quantity ,status ,subTotal ,userid from Cart");
		 int result=query.executeUpdate();
		
		return true;
		
	}
	
	@Transactional
	public List<Order> getAllOrderDetails() {
		@SuppressWarnings("unchecked")
		List<Order> Orderslist= (List<Order>) sessionFactory.getCurrentSession()
				.createQuery("from Order").list();

		return Orderslist;
	}
	
	
	@Transactional	
	public List getOrderDetailsByUser(int userid) {
			
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().createQuery("from Order where userid="+userid).list();
		}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Order> getTotal(int uid) {
		
		return (List<Order>) sessionFactory.getCurrentSession()
				.createQuery("select sum(subTotal) from Order where userid="+uid).list();

	}

}