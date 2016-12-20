package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ShippingAddress;


@EnableTransactionManagement
@Repository("ShippingAddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO {
	
	@Autowired // no need to create object of session factory ...automatically
	// created
private SessionFactory sessionFactory;

public ShippingAddressDAOImpl(SessionFactory sessionFactory) {
this.sessionFactory = sessionFactory;
}


@Transactional
	public boolean save(ShippingAddress shippingAddress) {
		try {
			sessionFactory.getCurrentSession().save(shippingAddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

@Transactional
	public boolean update(ShippingAddress shippingAddress) {
		try {
			sessionFactory.getCurrentSession().update(shippingAddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

@Transactional
	public boolean delete(ShippingAddress shippingAddress) {
		try {
			sessionFactory.getCurrentSession().delete(shippingAddress);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

@Transactional
	public ShippingAddress getById(String ShippingAddressID) {
	String hql = "from ShippingAddress where pro_Id="+"'"+ShippingAddressID+"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<ShippingAddress> list = query.list();

	if (list == null || list.isEmpty()) {
		return null;
	} else {
		return list.get(0);
	}
}

}
