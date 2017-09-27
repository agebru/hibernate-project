package com.hibernate.service;

import java.util.List;

import com.hibernate.entity.Address;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
public interface AddressService {

    List<Address> findAllAddresses();

    void save(Address address);

}
