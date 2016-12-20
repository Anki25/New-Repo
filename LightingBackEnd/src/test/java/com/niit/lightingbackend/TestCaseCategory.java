package com.niit.lightingbackend;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.User;

public class TestCaseCategory {

	@Autowired //objects of the class will be directly injected
	CategoryDAO categoryDAO;
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	
	@Autowired
	Category category;

	AnnotationConfigApplicationContext context;
	
	@Before    //
	public void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO= (UserDAO) context.getBean("userDAO"); //typecasting from object to categoryDAO
		
		user= (User) context.getBean("user");
	}
	
	@Test
	public void categoryAddTestcase()
	{
		user.setUserID("CG003");
		//user.setFirstname("SAMSAUNG");
		user.setPassword("SMARTPHONE");
		user.setCpassword("SMARTPHONE");
		user.setEmailid("SMARTPHONE");
		user.setMobileno("SMARTPHONE");
		user.setAddress("SMARTPHONE");
		user.setRole("SMARTPHONE");
		
		boolean flag= userDAO.saveOrUpdate(user);
		assertEquals(flag,true);
	}
	
	
	//@Test
	public void categoryListTestCase()
	{
		List<Category> list = categoryDAO.list();
		int rowCount= list.size();  //gives no.of rows
		assertEquals("Category List Test Case", rowCount,4);   //(expected, actual)if actual rows is 5
		for(Category x:list){
			System.out.println(x.getCat_id() + "-" + x.getCat_name() + "-" + x.getDescription());
		}
	}
	
		
	//@Test
	public void categoryGetTestCase()
	{
		 category = categoryDAO.get("CG003");
		System.out.println(category.getDescription());
		System.out.println(category.getCat_name());
		assertEquals(category.getCat_name(), "SAMSUNG"); 
		assertEquals("getCategoryTestCase",categoryDAO.get("CG003"), null);
	}
	
	//@Test
	public void categoryDeleteTestcase()
	{
         category.setCat_id("sadfdg");
		
		boolean flag = categoryDAO.delete(category);
		
		assertEquals("deleteCategoryTestCase",flag, true);

	}
	
	 //@Test
	public void updateCategoryTestCase()
	{
		category.setCat_id("CG003");
		category.setCat_name("SAMSUNG");
		category.setDescription("SMARTPHONE");
		assertEquals("updateCategoryTestCase",categoryDAO.saveOrUpdate(category), true); //msg displays left side
	} 
	
}
