package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Supplier;

public interface SupplierDAO {
	public boolean save(Supplier category);
	public boolean update(Supplier category);
	public boolean delete(Supplier category);
	public Supplier get(String id);
	
	public List<Supplier> list();

}
