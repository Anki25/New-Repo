package com.niit.lightingbackend;

/*import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class TestCaseProduct {

	//to write test case for product we need productDAO and product object(instead of creating object..inject(autowired))

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	AnnotationConfigApplicationContext context;
	
	//u can write a method to initialize the objects..method can be anything...@before is used to refer method
	
	@Before
	//@BeforeClass annotation specifies that method will be invoked only once, before starting all the tests.

//@Before annotation specifies that method will be invoked before each test.
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		productDAO =(ProductDAO) context.getBean("ProductDAO");
		
		product = (Product) context.getBean("product");
		}
	
	@Test
	public void productAddTestcase()
	{
		product.setPro_Id("MOB_001");
		product.setPro_name("iphone");
		product.setDescription("apple product");
		product.setPrice(50000);
	
				
		assertEquals("addProductTestcase", productDAO.save(product),false); //instaed of boolean flag 
		//void assertEquals(boolean expected,boolean actual): checks that two primitives/objects are equal. 
		 //It is overloaded.

	
	}
	
	@Test
	public void deleteProductTestCase()
	{
		
		product.setPro_Id("PRD_001");
		
		boolean flag = productDAO.delete(product);
		
		assertEquals("deleteProductTestCase",flag, false);
	}
	
	@Test
	public void listProductTestCase()
	{
		assertEquals("listProductTestCase", productDAO.list().size(),2);
	}
	
	@Test
	public void updateProductTestCase()
	{
		product.setPro_Id("MOB_004");
		product.setPro_name("LenovoK5");
		product.setDescription("this is lenovo");
		product.setPrice(2000);
	assertEquals("updateProductTestCase",productDAO.update(product), true); //msg displays left side
	}
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase",productDAO.get("MOB_004"), null);
		
	}
	
	}
	*/
	
	