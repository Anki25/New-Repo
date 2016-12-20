package com.niit.lightingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO"); //getbean returns object it has to be typecasted to DAO
		Supplier supplier = (Supplier) context.getBean("supplier");
		
		supplier.setSup_id("SUP001");
	    supplier.setSup_name("SUPName001");
	    supplier.setAddress("This is the description");
	    
	    if(supplierDAO.saveOrUpdate(supplier)==true)
	    {
	    	System.out.println("Success");
	    		    }
	    else{
	    	System.out.println("Not able to create");
	    }
	    
	    System.out.println("No.of supliers" + supplierDAO.list().size());
	    
	} 
}
