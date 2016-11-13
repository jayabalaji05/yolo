package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
	 this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean save(Supplier category) {
		try {
			sessionFactory.openSession().save(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(Supplier category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

@Transactional
	public boolean delete(Supplier category) {
		try {
			sessionFactory.openSession().delete(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier get(String id) {
		return(Supplier) sessionFactory.openSession().get(Supplier.class,id);
	}

	public List<Supplier> list() {
		String hql="from Product";
		Query query= sessionFactory.openSession().createQuery(hql);
	    return  query.list();
	}

}
