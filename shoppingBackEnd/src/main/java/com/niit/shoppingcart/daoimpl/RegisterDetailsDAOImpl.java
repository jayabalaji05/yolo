package com.niit.shoppingcart.daoimpl;

import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingbackend.dao.RegisterDetailsDAO;
import com.niit.shoppingbackend.model.RegisterDetails;
import com.niit.shoppingbackend.model.User;

@Repository("registerDAO")
public  class RegisterDetailsDAOImpl implements RegisterDetailsDAO{
@Autowired
SessionFactory sessionFactory;
public RegisterDetailsDAOImpl(SessionFactory sessionFactory)
{
 this.sessionFactory=sessionFactory;
}

@Autowired
@Transactional
public void adduser(RegisterDetails reg) {
	System.out.println("Registering DAO ");
	System.out.println(reg.getUsername());
	User u=new User();
	u.setUsername(reg.getUsername());
	u.setPassword(reg.getPassword());
	System.out.println("Login Credentials");
	try
	{
	 Session session=sessionFactory.openSession();
	 Transaction tx=(Transaction) session.beginTransaction();
	 //tx.begin();
	 session.save(reg);
	 session.save(u);
	 tx.commit();
	 session.flush();
	 session.close();
    }
	catch(Exception ex)
	{
		System.out.println("Error " +ex);
	}
}
@Transactional
public RegisterDetails getinfo(String u) {
	Session session=sessionFactory.openSession();
	Transaction tx=(Transaction) session.getTransaction();
	//tx.begin();
	RegisterDetails logobj=(RegisterDetails)session.get(RegisterDetails.class,u);
	//System.out.println(logobj.getUsername());
	try {
		tx.commit();
	} 
	catch (Exception e)
	{
		System.out.println("Error " +e);
	}
	return logobj;
		}
	}
