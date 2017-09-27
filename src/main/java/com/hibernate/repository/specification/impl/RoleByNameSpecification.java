package com.hibernate.repository.specification.impl;

import lombok.AllArgsConstructor;

import com.hibernate.repository.specification.Specification;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@AllArgsConstructor
public class RoleByNameSpecification implements Specification {

    private String name;

    @Override
    public String toSqlClause(final String alias) {
        return String.format("WHERE %s.name = '%s'", alias, name);
    }

}
