package com.hibernate.service.impl;

import java.util.List;

import com.hibernate.entity.Address;
import com.hibernate.repository.impl.AddressRepository;
import com.hibernate.repository.specification.impl.AddressSpecification;
import com.hibernate.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Service
public class JpaAddressService implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findBySpecification(new AddressSpecification());
    }

    @Override
    public void save(final Address address) {
        addressRepository.save(address);
    }

}
