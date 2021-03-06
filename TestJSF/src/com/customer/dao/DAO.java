package com.customer.dao;

public interface DAO<K, E> {
    void persist(E entity);
    void remove(E entity);
    E findById(K id);
}
