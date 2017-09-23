package com.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hibernate.repository.specification.Specification;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
public abstract class JpaCrudRepository<T> implements CrudRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> clazz;

    private String alias;

    private final String SELECT_QUERY = "SELECT %s FROM %s %s";

    public JpaCrudRepository(final Class<T> clazz, final String alias) {
        this.clazz = clazz;
        this.alias = alias;
    }

    @Override
    public void save(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findBySpecification(final Specification specification) {
        return entityManager.createQuery(String.format(SELECT_QUERY, alias, clazz.getSimpleName(), alias) +
                specification.toSqlClause(alias)).getResultList();
    }

    @Override
    public T findOne(final Object pk) {
        return entityManager.find(clazz, pk);
    }

}
