package com.niit.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.model.Supplier;

@Component
public interface SupplierDAO {
	public boolean save(Supplier category);
	public boolean update(Supplier category);
	public boolean delete(Supplier category);
	public Supplier get(String id);
	
	public List<Supplier> list();
	public void removeCategory(Supplier id);

}
