package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Cart;

@Repository
public interface CartDAO {
	
	public boolean save(Cart cart);
	
	public boolean update(Cart cart);
	
	public boolean delete(Cart cart);
	
	public Cart get(String id,String userid);
	
	public List<Cart> list(String id);
	public int totalproducts(String id);
	public float totalprice(String id);	
	public Cart getById(String CartID);
	public List<Cart> mycartproducts(String id);
}
