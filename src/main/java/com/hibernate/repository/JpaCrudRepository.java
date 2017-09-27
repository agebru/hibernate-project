package com.hibernate.repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.hibernate.repository.specification.Specification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
public abstract class JpaCrudRepository<T> implements CrudRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> clazz;

    private String alias;

    private final String SELECT_QUERY = "SELECT %s FROM %s %s ";

    private Logger logger = LoggerFactory.getLogger(JpaCrudRepository.class);

    public JpaCrudRepository(final Class<T> clazz, final String alias) {
        this.clazz = clazz;
        this.alias = alias;
    }

    @Override
    @Transactional
    public void save(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findBySpecification(final Specification specification) {
        List<T> result = Collections.emptyList();
        try {
            result = entityManager.createQuery(String.format(SELECT_QUERY, alias, clazz.getSimpleName(),
                    alias) + specification.toSqlClause(alias)).getResultList();
        } catch (final Exception ex) {
            logger.error("Caught: " + ex);
        }

        return result;
    }

    @Override
    public T findOne(final Object pk) {
        return entityManager.find(clazz, pk);
    }

}
