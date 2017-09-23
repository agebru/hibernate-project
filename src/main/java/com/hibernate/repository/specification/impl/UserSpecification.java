package com.hibernate.repository.specification.impl;

import com.hibernate.repository.specification.Specification;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
public class UserSpecification implements Specification {

    @Override
    public String toSqlClause(final String alias) {
        return StringUtils.EMPTY;
    }

}
