package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;
import com.niit.model.Product;
import com.niit.model.Cart;

@SuppressWarnings("deprecation")
@EnableTransactionManagement
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired // no need to create object of session factory ...automatically
	// created
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Cart cart) { // TODO
		// Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Cart cart) { // TODO
		// -generated method stub
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Cart cart) { // since object is given
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Cart> list(String id){
		// TODO Auto-generated method stub
		String hql = " from Cart where userID="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql); 
		return query.list();

	}
	
	@Transactional
	public Cart get(String id,String Cartid) {
		// TODO Auto-generated method stub
		System.out.println("Inside getproductByName daoimpl");
		System.out.println("id:" + id);
		String hql = "from Cart where pro_Id=" + "'"+id+"'" + "and CartID="+ "'"+Cartid+"'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> list = query.list();

		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}
	
	@Transactional
	public Cart getById(String CartID) {
		// TODO Auto-generated method stub selct * from Cart where id = '101'
		String hql = "from Cart where CartId='" + CartID + "'"; // Cart is d
																	// domain
																	// object
																	// name not
																	// table
																	// name

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>)query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("Cart retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}
	
	
	
	@Transactional
	public float totalprice(String id){
		try{
			String hql = "from Cart where userID=" + "'" + id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Cart> all = query.list();
	
			float k=0;
			for (Cart temp : all) {
				k = k + temp.getPrice();
			}		
			return k;	
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
		
		
		}
	
	
	
	
	
	@Transactional
	public int totalproducts(String id) {
		try {
			String hql = "from Cart where userID=" + "'" + id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Cart> all = query.list();
			int k = 0;
			for (Cart temp : all) {
				k = k + 1;
			}
			return k;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
@Transactional
	public List<Cart> mycartproducts(String id) {
		
			String hql = "from Cart where userID=" + "'" + id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql); 
			
			List<Cart> all = query.list();
			return all;
		
	}
}
