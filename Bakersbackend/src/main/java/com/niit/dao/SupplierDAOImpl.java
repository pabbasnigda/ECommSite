package com.niit.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Supplier;


@Repository
public class SupplierDAOImpl implements SupplierDAO 
{
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
	public boolean saveSupplier(Supplier supplier) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}
	
	@Transactional
	public List<Supplier> list() 
	{
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listSupplier;
	}
	
	@Transactional
	public Supplier getSupplierById(int supplier_id) 
	{
		String hql = "from"+" Supplier"+" where id=" + supplier_id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) ((org.hibernate.Query) query).list();
		
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}
	
	@Transactional
	public Supplier removeSupplierById(int supplier_id) 
	{
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setSupplier_id(supplier_id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
		return SupplierToDelete;
	}
	
}
