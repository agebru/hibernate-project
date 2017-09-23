package com.hibernate.service.impl;

import java.util.List;
import java.util.Objects;

import com.hibernate.entity.User;
import com.hibernate.entity.UserId;
import com.hibernate.repository.impl.UserRepository;
import com.hibernate.repository.specification.impl.UserByEmailSpecification;
import com.hibernate.repository.specification.impl.UserSpecification;
import com.hibernate.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
@Service
public class JpaUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(final User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(final User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findBySpecification(new UserSpecification());
    }

    @Override
    public User findUserByPk(final UserId userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User findUserByEmail(final String email) {
        final List<User> users = userRepository.findBySpecification(new UserByEmailSpecification(email));
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public boolean isEmailExist(final String email) {
        return Objects.nonNull(findUserByEmail(email));
    }

}
