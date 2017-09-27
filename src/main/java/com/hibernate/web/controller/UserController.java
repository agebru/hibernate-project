package com.hibernate.web.controller;

import java.util.Objects;

import javax.validation.Valid;

import com.hibernate.entity.User;
import com.hibernate.service.UserService;
import com.hibernate.web.converter.Converter;
import com.hibernate.web.dto.UserDto;
import com.hibernate.web.exception.DuplicateEmailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserDto> userConverter;

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void register(@RequestBody @Valid UserDto userDto) throws DuplicateEmailException {
        if (!isPasswordConfirmed(userDto)) {
            throw new IllegalArgumentException("Password is not confirmed");
        }
        if (userService.isEmailExist(userDto.getEmail())) {
            throw new DuplicateEmailException("Email is already exists");
        }

        final User user = userConverter.convertToEntity(userDto);
        userService.save(user);
    }

    private boolean isPasswordConfirmed(final UserDto userDto) {
        return Objects.equals(userDto.getPassword(), userDto.getConfirmPassword());
    }

}
