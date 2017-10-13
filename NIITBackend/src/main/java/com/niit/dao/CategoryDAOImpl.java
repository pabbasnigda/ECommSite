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
	
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
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

	@SuppressWarnings("rawtypes")
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
			 System.out.println("Category id : "+c.getCid());
			 System.out.println("Category Name : "+c.getCatName());
			 System.out.println("Category Description : "+c.getCatDescription());
			 System.out.println("-------------------");
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
