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

import com.niit.model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean saveUserDetails(UserDetails user) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(user);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}

	@Transactional
	public boolean updateUserDetails(int Uid) 
	{
		 Session session = sessionFactory.openSession();
		 Object o=session.load(UserDetails.class,new Integer(140));
		 UserDetails u=(UserDetails)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 u.setUaddress("Hyd"); // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	}
	
	@Transactional
	public boolean deleteUserDetails(int Uid) 
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM UserDetails WHERE Uid = "+Uid).executeUpdate();
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public boolean getAllUserDetails() 
	{
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from UserDetails u");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 UserDetails u = (UserDetails)o;
			 System.out.println("User id : "+u.getUid());
			 System.out.println("User Name : "+u.getUserName());
			 System.out.println("User Address : "+u.getUaddress());
			 System.out.println("User Email :"+u.getEmail());
			 System.out.println("User Phone :"+u.getPhone());
			 System.out.println("----------------------");
		 } 

		return true;

	}

}
