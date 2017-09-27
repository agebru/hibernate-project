package com.hibernate.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.hibernate.entity.Address;
import com.hibernate.service.AddressService;
import com.hibernate.web.converter.Converter;
import com.hibernate.web.dto.AddressDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@RestController
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class AdminController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private Converter<Address, AddressDto> addressConverter;

    @GetMapping()
    @RequestMapping("/addresses")
    public List<AddressDto> getAllAddresses() {
        final List<Address> addresses = addressService.findAllAddresses();
        return addresses.stream().map(a -> addressConverter.convertToDto(a)).collect(Collectors.toList());
    }

}
