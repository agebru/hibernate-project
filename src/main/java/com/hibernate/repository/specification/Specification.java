package com.hibernate.repository.specification;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
public interface Specification {

    String toSqlClause(String alias);

}
