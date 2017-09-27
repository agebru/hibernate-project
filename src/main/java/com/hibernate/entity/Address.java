package com.hibernate.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Entity
@Table(name = "addresses")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column
    private String city;

    @Column
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "flat_number")
    private String flatNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({  // User class has composite primary key
            @JoinColumn(name = "user_id"),
            @JoinColumn(name = "country")
    })
    @JsonIgnore // to avoid infinite recursion with Jackson JSON and Hibernate JPA
    private User user;

}