package com.hibernate.repository.impl;

import com.hibernate.entity.Role;
import com.hibernate.repository.JpaCrudRepository;

import org.springframework.stereotype.Repository;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Repository
public class RoleRepository extends JpaCrudRepository<Role> {

    public RoleRepository() {
        super(Role.class, "r");
    }

}
