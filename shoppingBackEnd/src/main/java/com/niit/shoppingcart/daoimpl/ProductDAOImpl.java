package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
	 this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean save(Product category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(Product category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean delete(Product category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public Product get(String id) {
		return(Product) sessionFactory.getCurrentSession().get(Product.class,id);
	}
@Transactional
	public List<Product> list() {
		String hql="from Product";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
	    return  query.list();
	}

}
