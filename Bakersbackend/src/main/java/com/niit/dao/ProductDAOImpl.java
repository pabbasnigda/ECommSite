package com.niit.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean saveProduct(Product product) 
	{
		System.out.println("Persisting Product object started.........");
		//Session session=sessionFactory.openSession();
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		System.out.println("Product has been saved successfully....");
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> list() 
	{
		List<Product> product = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		return product;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Product getProductById(int product_id) 
	{
		String hql = "from" + " Product" + " where id=" + product_id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) ((ProductDAOImpl) query).list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Product removeProducyById(int product_id) 
	{
		Product ProductToDelete = new Product();
		ProductToDelete.setId(product_id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		return ProductToDelete;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getProductByCategory(int category_id) 
	{
		String hql = "from" + " Product" + " where id=" +category_id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		
		List<Product> listProduct = (List<Product>) ((ProductDAOImpl) query).list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return (List<Product>) listProduct.get(0);
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List<Product> getProductByCategoryID(int category_id) 
	{
		String hql = "from Product where category_id= "+category_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> catproducts = (List<Product>) ((ProductDAOImpl) query).list();
		return catproducts;
	}

	@Transactional
	public List<Product> homeList() 
	{
		String hql="from Product ORDER BY RAND()";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql).setMaxResults(6);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) ((ProductDAOImpl) query).list();
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct;
		}
		return null;
	}	
}
