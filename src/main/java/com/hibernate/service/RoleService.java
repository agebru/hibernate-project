package com.hibernate.service;

import com.hibernate.entity.Role;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
public interface RoleService {

    Role findRoleByName(final String name);

}
