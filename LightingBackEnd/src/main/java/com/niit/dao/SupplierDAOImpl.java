package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Supplier;

@EnableTransactionManagement
@Repository(value= "supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired  
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;		
	}
	
	/*@Transactional
	public boolean save(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
*/
	@Transactional
	public boolean delete(Supplier supplier) {     //(String id) since id is given object is created
		// TODO Auto-generated method stub
		/* Supplier supplier = new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier); */
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	
	}

	@Transactional
	public Supplier get(String id) {
		// TODO Auto-generated method stub
        String hql = "from Supplier where sup_id= " + "'"+id+"'";  //category is d domain object name not table name
		@SuppressWarnings({ "rawtypes", "deprecation" })
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "deprecation", "unchecked" })
		List <Supplier> list = query.list();
		if(list==null || list.isEmpty())
		{
		return null;
	}else
	{ return list.get(0);
	}
			
	}

	@Transactional
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		String hql = " from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  //to add try catch right click surround with
		List<Supplier> list =  query.list();
		System.out.println("Supplier DAO");
		if(list==null || list.isEmpty())
		{
			//log.info("No categories are available");
		}
		return query.list();
		
	
	}

	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			System.out.println("In supplierDAOImpl");
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	
	}

	@Transactional
	public Supplier getName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Inside getsupplierByName daoimpl");
		System.out.println("name:" + name);
        String hql = "from Supplier where sup_name= " + "'"+name+"'";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List <Supplier> list = query.list();
		
		if(list==null || list.isEmpty())
		{
		return null;
	}else
	{ return list.get(0);
	}
	
	}

	

}
