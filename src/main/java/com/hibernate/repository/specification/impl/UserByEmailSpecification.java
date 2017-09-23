package com.hibernate.repository.specification.impl;

import lombok.AllArgsConstructor;

import com.hibernate.repository.specification.Specification;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
@AllArgsConstructor
public class UserByEmailSpecification implements Specification {

    private String email;

    @Override
    public String toSqlClause(final String alias) {
        return String.format("WHERE %s.email = '%s'", alias, email);
    }

}
