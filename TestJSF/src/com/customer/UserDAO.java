package com.customer;

import javax.ejb.Stateless;

@Stateless
public interface UserDAO extends DAO<Integer, User> {

	boolean getLoginDetails(String user, String password);
}
