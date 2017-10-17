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

import com.niit.model.Supplier;


@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private SupplierDAO supplierDAO;
	
	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}
	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean createSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(supplier);
		Transaction tx=session.beginTransaction();
		tx.commit();
		return true;
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub

		 Session session = sessionFactory.openSession();
		 Object o=session.load(Supplier.class,new Integer(145));
		 Supplier s=(Supplier)o;
		 
		 Transaction tx = session.beginTransaction(); 
		 s.setSupName("Greenmobiles");  // implicitly update method will be called.
		 tx.commit();
		 
		 return true;
	}

	


	@Transactional
	public boolean deleteSupplier(int SupId) {
		// TODO Auto-generated method stub	
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Supplier WHERE id = "+SupId).executeUpdate();
		return true;	
	}
	@SuppressWarnings("rawtypes")
	@Transactional
	
	public boolean getSupplier(int SupId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query qry = session.createQuery("from Supplier s");
		List l=qry.getResultList();
		
		System.out.println("Total Number Of Records : "+l.size());
		Iterator it = l.iterator();
		 
		while(it.hasNext())
		 {
			 Object o = (Object)it.next();
			 Supplier s = (Supplier)o;
			 System.out.println("Supplier Name : "+s.getSupName());
			 System.out.println("----------------------");
		 } 
		return true;
	}

}
