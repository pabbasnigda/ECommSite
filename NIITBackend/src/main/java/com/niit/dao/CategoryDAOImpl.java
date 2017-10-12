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

import com.niit.model.Category;
import com.niit.model.Product1;

@Repository
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CategoryDAO categoryDAO;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	} 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional  //for transaction management
	public boolean saveCategory(Category category) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(category);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}
	
	@Transactional
	public boolean deleteCategory(int Cid) 
	{
		sessionFactory.getCurrentSession().createQuery("DELETE FROM CATEGORY_DETAILS WHERE Cid = "+Cid).executeUpdate();
		return true;
	}

	@Transactional
	public boolean getAllCategoryList() 
	{
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Category c");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Category c=(Category)o;
			 System.out.println("Product id : "+c.getCid());
			 System.out.println("Product Name : "+c.getCatName());
			 System.out.println("Product Price : "+c.getCatDescription());
			 System.out.println("----------------------");
		 } 

		return true;
	}

	@Transactional
	public boolean updateCategory(int Cid) 
	{
		 Session session = sessionFactory.openSession();
		 Object o=session.load(Category.class,new Integer(160));
		 Category s=(Category)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setCatDescription("full tasty");  // implicitly update method will be called.
		 tx.commit();
		 
		 System.out.println("Object Updated successfully.....!!");
		 return true;
	}

	public boolean getCategorybyId(int Cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
