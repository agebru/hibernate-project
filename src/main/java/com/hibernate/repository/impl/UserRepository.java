package com.hibernate.repository.impl;

import com.hibernate.entity.User;
import com.hibernate.repository.JpaCrudRepository;

import org.springframework.stereotype.Repository;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
@Repository
public class UserRepository extends JpaCrudRepository<User> {

    public UserRepository() {
        super(User.class, "u");
    }

}
