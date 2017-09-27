package com.hibernate.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.google.common.collect.Sets;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
@Entity
@IdClass(UserId.class)
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "password")
public class User {

    /** Compound Primary Key: Country + ID */
    @Id
    private String country;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private Set<Role> roles = Sets.newHashSet();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    public void addRole(Role role) {
        roles.add(role);
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

}
