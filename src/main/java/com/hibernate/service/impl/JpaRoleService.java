package com.hibernate.service.impl;

import java.util.List;

import com.hibernate.entity.Role;
import com.hibernate.repository.impl.RoleRepository;
import com.hibernate.repository.specification.impl.RoleByNameSpecification;
import com.hibernate.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Service
public class JpaRoleService implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByName(final String name) {
        final List<Role> list = roleRepository.findBySpecification(new RoleByNameSpecification(name));
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

}
