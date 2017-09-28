package com.hibernate.web.controller;

import java.security.Principal;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import com.hibernate.entity.Address;
import com.hibernate.entity.Passport;
import com.hibernate.entity.User;
import com.hibernate.entity.UserDetails;
import com.hibernate.service.AddressService;
import com.hibernate.service.RoleService;
import com.hibernate.service.UserService;
import com.hibernate.web.converter.Converter;
import com.hibernate.web.dto.AddressDto;
import com.hibernate.web.dto.UserDetailsDto;
import com.hibernate.web.dto.UserDto;
import com.hibernate.web.exception.DuplicateEmailException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
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
    private AddressService addressService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private Converter<UserDetails, UserDetailsDto> userDetailsConverter;

    @Autowired
    private Converter<User, UserDto> userConverter;

    @Autowired
    private Converter<Address, AddressDto> addressConverter;

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
        user.addRole(roleService.findRoleByName(userDto.getRoleName()));

        userService.save(user);
    }

    @PostMapping("/addresses")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addAddress(@RequestBody @Valid AddressDto addressDto, Principal principal) {
        final User user = userService.findUserByEmail(principal.getName());
        final Address address = addressConverter.convertToEntity(addressDto);
        address.setUser(user);
        addressService.save(address);
        // equivalent: user.addAddress(address); userService.update(user);
    }

    @PostMapping("/details")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addUserDetails(@RequestBody @Valid UserDetailsDto userDetailsDto, Principal principal) {
        final User user = userService.findUserByEmail(principal.getName());
        final UserDetails userDetails = userDetailsConverter.convertToEntity(userDetailsDto);

        user.setUserDetails(userDetails);
        userService.update(user);
    }

    private boolean isPasswordConfirmed(final UserDto userDto) {
        return Objects.equals(userDto.getPassword(), userDto.getConfirmPassword());
    }

}
