package com.hibernate.repository.impl;

import com.hibernate.entity.Address;
import com.hibernate.repository.JpaCrudRepository;

import org.springframework.stereotype.Repository;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Repository
public class AddressRepository extends JpaCrudRepository<Address> {

    public AddressRepository() {
        super(Address.class, "a");
    }

}
