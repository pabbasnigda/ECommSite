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
public class UserDetailsDAOImpl implements UserDAO {
	private static final String Uid = null;
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
	public boolean saveUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(user);
		Transaction tx=session.beginTransaction();
		tx.commit();
		session.flush();
		return true;
	}

	@Transactional
	public boolean updateUserDetails(int Uid) {
		// TODO Auto-generated method stub
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
	public boolean deleteUserDetails(int Uid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM UserDetails WHERE Uid = "+Uid).executeUpdate();
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public boolean getAllUserDetails() {
		// TODO Auto-generated method stub
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
			 System.out.println("User firstName : "+u.getUFirstname());
			 System.out.println("User lasttName : "+u.getULastname());
			 System.out.println("password is : "+u.getPassword());
			 System.out.println("User role : "+u.getRole());
			 System.out.println("User Address : "+u.getUaddress());
			 System.out.println("User Email :"+u.getEmail());
			 System.out.println("User Phone :"+u.getPhone());
			 System.out.println("----------------------");
		 } 
		return true;
	}

	public UserDetails getUserDetails(String email) {
		// TODO Auto-generated method stub
		UserDetails user =(UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, new String(email));	
		return user;
	}

	
	public UserDetails getUById(int customerId) {
		// TODO Auto-generated method stub

		UserDetails user =(UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, new Integer(Uid));	
		return user;
	}

	public boolean vaildate(String user, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public UserDetails getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails get(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
