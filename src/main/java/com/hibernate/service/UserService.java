package com.hibernate.service;

import java.util.List;

import com.hibernate.entity.User;
import com.hibernate.entity.UserId;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
public interface UserService {

    void save(User user);

    User update(User user);

    void delete(User user);

    List<User> findAll();

    User findUserByPk(UserId userId);

    User findUserByEmail(String email);

    boolean isEmailExist(String email);

}
