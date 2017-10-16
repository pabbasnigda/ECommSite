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

import com.niit.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CartDAO cartDAO;
	
	public CartDAO getCartDAO()
	{
		return cartDAO;
	}
	public void setCartDAO(CartDAO cartDAO)
	{
		this.cartDAO=cartDAO;
	}
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	@Transactional
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(cart);
		Transaction t = session.beginTransaction();
		t.commit();
		return true;
	}

	@Transactional
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Cart.class,new Integer(200));
		 Cart c = (Cart)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 c.setStatus("A");  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	}

	@Transactional
	public boolean deleteCart(int Cid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Cart WHERE Cid = "+Cid).executeUpdate();
		return true;
	}
	@SuppressWarnings("rawtypes")
	@Transactional
	public boolean getCartitems() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Cart c");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Cart c = (Cart)o;
			 System.out.println("Cart id : "+c.getCid());
			 System.out.println("Cart Price : "+c.getPrice());
			 System.out.println("Product id : "+c.getProductid());
			 System.out.println("Productname : "+c.getProductname());
			 System.out.println("Cart quantity : "+c.getQuantity());
			 System.out.println("Cart status : "+c.getStatus());
			 System.out.println("Cart username : "+c.getUsername());
			 System.out.println("----------------------");
		 } 

		return true;
	}

}
