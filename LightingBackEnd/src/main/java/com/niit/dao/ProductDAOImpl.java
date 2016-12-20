package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

@EnableTransactionManagement
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired // no need to create object of session factory ...automatically
				// created
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * @Transactional public boolean save(Product product) { // TODO
	 * Auto-generated method stub try{
	 * sessionFactory.getCurrentSession().save(product); return true;
	 * }catch(Exception e){ e.printStackTrace(); return false; } }
	 * 
	 * @Transactional public boolean update(Product product) { // TODO
	 * Auto-generated method stub try{
	 * sessionFactory.getCurrentSession().update(product); return true;
	 * }catch(Exception e){ e.printStackTrace(); return false; } }
	 */
	@Transactional
	public boolean delete(Product product) { // since object is given
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Product get(String id) {
		// TODO Auto-generated method stub selct * from product where id = '101'
		String hql = "from Product where pro_Id="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();

		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Transactional
	public List<Product> list() {
		// TODO Auto-generated method stub
		String hql = " from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		return query.list();

	}

	@Transactional
	public boolean saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Transactional
	public Product getName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Inside getproductByName daoimpl");
		System.out.println("name:" + name);
		String hql = "from Product where pro_name= " + "'" + name + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();

		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Transactional
	public Product getByCatId(String id) {
		// TODO Auto-generated method stub
		String hql = "from Product where cat_id= " + "'" + id + "'"; 

Query query = sessionFactory.getCurrentSession().createQuery(hql);
List<Product> list = query.list();

if (list == null || list.isEmpty()) {
return null;
} else {
return list.get(0);
}
}


}
