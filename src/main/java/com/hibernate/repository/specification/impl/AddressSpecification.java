package com.hibernate.repository.specification.impl;

import com.hibernate.repository.specification.Specification;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
public class AddressSpecification implements Specification {

    @Override
    public String toSqlClause(final String alias) {
        return String.format("JOIN FETCH %s.user u", alias); // N+1 query, loading lazy dependencies
    }

}
