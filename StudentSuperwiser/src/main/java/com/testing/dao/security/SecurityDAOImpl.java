package com.testing.dao.security;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testing.model.security.User;



@Repository
public class SecurityDAOImpl implements SecurityDAO {

	@Autowired
    private SessionFactory sessionFactory;

	 @Transactional
	 public User getUser(String username){
	    	Session session = sessionFactory.getCurrentSession();
	    	Criteria criteria = session.createCriteria(User.class);
	    	User user= (User) criteria.add(Restrictions.eq("username", username))
	    	                             .uniqueResult();
	    	return user;
	    }
	
	
}
