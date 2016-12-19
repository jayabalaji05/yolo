package com.niit.shoppingbackend.dao;

import java.util.List;
import com.niit.shoppingbackend.model.Supplier;
public interface SupplierDAO {
	public void addSupplier(Supplier p);

public void updateSupplier(Supplier p);

public List<Supplier> listSupplier();

public Supplier getSupplierById(int id);

public void removeSupplier(int id);
}
