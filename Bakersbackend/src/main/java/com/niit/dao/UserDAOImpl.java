package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;



@Repository
public class UserDAOImpl implements UserDAO 
{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	
	@Transactional
	public boolean saveUser(User user) {
		
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		return true;
	}

public List<User> list() {
		
		return null;
	}

@Transactional
public User getUser(int userid) {
	// TODO Auto-generated method stub
	return (User)sessionFactory.getCurrentSession().get(User.class, userid);
}
@Transactional
public List getAllUser() {
	// TODO Auto-generated method stub
	return sessionFactory.getCurrentSession().createQuery("from User").list();
}


	public void removeUserById(int userid) {
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public User get(String email) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email));

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}

	}

/*@Transactional
	public List<Users> getUserById(int user_id) {
		// TODO Auto-generated method stub
	@SuppressWarnings("unchecked")
	List<Users> listUsers= (List<Users>) sessionFactory.getCurrentSession()
			.createQuery("from Users where id="+user_id).list();
		return listUsers;	}*/
	
	
	@SuppressWarnings("unchecked")
	@Transactional	
	public List<User> getUserById(int userid) {
			
			// TODO Auto-generated method stub
			return (List<User>) sessionFactory.getCurrentSession().createQuery("from User where id="+userid).list();
		}

	public User gtUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}


}