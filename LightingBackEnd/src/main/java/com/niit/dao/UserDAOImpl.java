package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@SuppressWarnings("deprecation")
@Repository(value = "UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired // no need to create object of session factory ...automatically
				// created
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * @Transactional public boolean save(User user) { // TODO Auto-generated
	 * method stub try{ sessionFactory.getCurrentSession().save(user); return
	 * true; }catch(HibernateException e){ e.printStackTrace(); return false; }
	 * }
	 * 
	 * @Transactional public boolean update(User user) { // TODO Auto-generated
	 * method stub try{ sessionFactory.getCurrentSession().update(user); return
	 * true; }catch(HibernateException e){ e.printStackTrace(); return false; }
	 * }
	 */
	@Transactional
	public boolean delete(User user) { // since object is given
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public User get(String userID) {
		// TODO Auto-generated method stub selct * from user where id = '101'
		String hql = "from User where userID='" + userID + "'"; // user is d
																	// domain
																	// object
																	// name not
																	// table
																	// name

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>)query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("user retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public User getName(String name) {
		// TODO 
		String hql = "from User where userID=" + "'" + name + "'"; 
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>)query.list();

		if (list != null && !list.isEmpty()) {
			System.out.println("username retrieved from DAOImpl");
			return list.get(0);
		} else {
			return null;
		}
	}

	
	@Transactional
	public boolean isValidUser(String userID, String password) {
		String hql = "from User where userID = '" + userID + "' and password='" + password + "'"; // select
																									// *
																									// from
																									// user
																									// where
																									// id='101'
																									// and
																									// password
																									// 'niit'

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> list() {
		// TODO Auto-generated method stub
		String hql = " from User";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql); // to
																			// add
																			// try
																			// catch
																			// right
																			// click
																			// surround
																			// with
		return query.list();

	}

	@Transactional
	public boolean saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
