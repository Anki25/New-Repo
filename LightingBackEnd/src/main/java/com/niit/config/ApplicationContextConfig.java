package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartDAO;
import com.niit.dao.CartDAOImpl;
import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImpl;
import com.niit.dao.ShippingAddressDAO;
import com.niit.dao.ShippingAddressDAOImpl;
import com.niit.dao.SupplierDAO;
import com.niit.dao.SupplierDAOImpl;
import com.niit.dao.UserDAO;
import com.niit.dao.UserDAOImpl;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement

public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")                               
	public DataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/ankita");

	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    return dataSource;
	}

	private Properties getHibernateProperties() {

		  Properties properties = new Properties();
		  properties.put("hibernate.show_sql", "true");   //to display the queries ,,,,can be given false if u want to hide the queries
		  properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		  properties.put("hibernate.hbm2ddl.auto", "update");
		 // properties.put("hibernate.current_session_context_class","thread"); 
		  return properties;
		}



		@Autowired   //automatically bean is created n injected
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource)  {

		  LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);  //sessionBuilder can b any other name too
		  sessionBuilder.addProperties(getHibernateProperties());
		  sessionBuilder.addAnnotatedClass(Category.class);
		  sessionBuilder.addAnnotatedClass(Supplier.class);
		  sessionBuilder.addAnnotatedClass(Product.class);
		  sessionBuilder.addAnnotatedClass(User.class);
		  sessionBuilder.addAnnotatedClass(Cart.class);
		  sessionBuilder.addAnnotatedClass(ShippingAddress.class);
		  return sessionBuilder.buildSessionFactory();
		}

		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
		  SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);  //should be same name as bean name of session factory
		return transactionManager;
		}
		
		
		 @Autowired
		@Bean(name = "categoryDAO")
            public CategoryDAO getCategoryDAO (SessionFactory sessionFactory){
			return new CategoryDAOImpl(sessionFactory);
		}
		 
		 @Autowired
			@Bean(name = "category")
	            public Category getCategory (){
				return new Category();
			}
		 
		@Autowired
		@Bean(name = "supplierDAO")
            public SupplierDAO getSupplierDAO (SessionFactory sessionFactory){
			return new SupplierDAOImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name = "supplier")
            public Supplier getSupplier (){
			return new Supplier();
		}
		
		@Autowired
		@Bean(name = "productDAO")
            public ProductDAO getProductDAO (SessionFactory sessionFactory){
			return new ProductDAOImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name = "product")
            public Product getProduct (){
			return new Product();
		}
		
		@Autowired
		@Bean(name = "userDAO")
            public UserDAO getUserDAO (SessionFactory sessionFactory){
			return new UserDAOImpl(sessionFactory);
		} 
		
		@Autowired
		@Bean(name = "cartDAO")
            public CartDAO getCartDAO (SessionFactory sessionFactory){
			return new CartDAOImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name = "user")
            public User getUser (){
			return new User();
		}

		@Autowired
		@Bean(name = "shippingAddressDAO")
            public ShippingAddressDAO getShippingAddressDAO (SessionFactory sessionFactory){
			return new ShippingAddressDAOImpl(sessionFactory);
		}
}





