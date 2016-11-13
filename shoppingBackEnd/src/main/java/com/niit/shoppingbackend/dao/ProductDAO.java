package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.model.Product;

public interface ProductDAO {
	public boolean save(Product category);
	public boolean update(Product category);
	public boolean delete(Product category);
	public Product get(String id);
	
	public List<Product> list();

}
