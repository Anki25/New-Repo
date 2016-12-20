package com.niit.dao;

import com.niit.model.ShippingAddress;

public interface ShippingAddressDAO {
	
   public boolean save(ShippingAddress shippingAddress);
	
	public boolean update(ShippingAddress shippingAddress);
	
	public boolean delete(ShippingAddress shippingAddress);
	
	public ShippingAddress getById(String ShippingAddressID);

}
