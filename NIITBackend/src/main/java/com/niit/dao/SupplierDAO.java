package com.niit.dao;

import com.niit.model.Supplier;

public interface SupplierDAO 
{
	public boolean createSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean getSupplier();
	public boolean deleteSupplier(int SupId);
}
