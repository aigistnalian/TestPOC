package com.customer.dao;

import javax.ejb.Stateless;

import com.customer.backing.User;

@Stateless
public interface UserDAO extends DAO<Integer, User> {

	boolean getLoginDetails(String user, String password);
}
