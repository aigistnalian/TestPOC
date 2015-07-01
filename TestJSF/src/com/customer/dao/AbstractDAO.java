package com.customer.dao;

import java.lang.reflect.ParameterizedType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public abstract class AbstractDAO<K, E> implements DAO<K, E> {

	@PersistenceContext
	protected EntityManager entityManager;
	
		protected Class<E> entityClass;
	 
	 
		public AbstractDAO() {
			ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
			this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		}
	 
		public void persist(E entity) { entityManager.persist(entity); }
	 
		public void remove(E entity) { entityManager.remove(entity); }
	 
		public E findById(K id) { return entityManager.find(entityClass, id); }
}
