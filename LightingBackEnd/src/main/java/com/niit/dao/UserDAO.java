package com.niit.dao;

import java.util.List;


import com.niit.model.User;


public interface UserDAO {
 
	 //Declare all CRUD operations
	public boolean saveOrUpdate(User user);
	
	//public boolean save(User user);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	//public boolean update(User user);
	
	public boolean delete(User user);
	
	public User get(String userID);
	
	public User getName(String name);
	
	public List<User> list();
	
	public boolean isValidUser(String userID, String password);
}
