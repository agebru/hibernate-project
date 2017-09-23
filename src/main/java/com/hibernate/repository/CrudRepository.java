package com.hibernate.repository;

import java.util.List;

import com.hibernate.repository.specification.Specification;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
public interface CrudRepository<T> {

    void save(T entity);

    T update(T entity);

    void delete(T entity);

    List<T> findBySpecification(Specification specification);

    T findOne(Object pk);

}
