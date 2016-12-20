package com.niit.lightingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


public class CategoryTest {
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		
	
	AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();

	CategoryDAO categoryDAO = (CategoryDAO)context.getBean("categoryDAO"); //getbean returns object it has to be typecasted to DAO
			Category category=(Category)context.getBean("category");
	       
			category.setCat_id("CG032");
		    category.setCat_name("CGName002");
		    category.setDescription("This is the next description");
		    if(categoryDAO.saveOrUpdate(category)==true)
		    {
		    	System.out.println("Success");
		    		    }
		    else{
		    	System.out.println("Not able to create");
		    }
}
	
}
