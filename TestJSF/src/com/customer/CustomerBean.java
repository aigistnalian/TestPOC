/**
 * 
 */
package com.customer;

import java.io.Serializable;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;

import com.customer.backing.Customer;

/**
 * @author analian
 *
 */
@ManagedBean(name="customer")
@SessionScoped
public class CustomerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	EntityManager entityManager;
	
	public List<Customer> custList;

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerList() throws SQLException{
		 Query query = entityManager.createQuery("SELECT c FROM Customer c");
		 custList = (List<Customer>)query.getResultList();
		 return custList;
	}
	@Transactional
	public void remove(Customer customer){
		try {
			entityManager.remove(customer);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	@Transactional
	public String submit() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException
	{
		Customer customer = new Customer();
		customer.setAddress(new SecureRandom().generateSeed(6).toString());
		customer.setCustomerID(new Random().nextLong());
		customer.setName("RAHUL");
		customer.setCreated_date(new Date(System.currentTimeMillis()));
		saveCustomer(customer);
		return "fa";
	}
	
	public void saveCustomer(Customer customer){
		entityManager.persist(customer);
		entityManager.flush();
	}
	
}
