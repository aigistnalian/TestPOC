package com.customer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
@Stateless
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO  {
	
	@Override
	public boolean getLoginDetails(String user, String password) {
		 Query query = entityManager.createQuery("Select u from User u where u.user = '" + user + "' and u.pass = '" + password + "'" );
		 
		 @SuppressWarnings("unchecked")
		List<User> users = (List<User>)query.getResultList();
		 System.out.println(users);
		 if(users!=null && !users.isEmpty())
	       {
			 return true;
	       }
		 return false;
	    }
}
