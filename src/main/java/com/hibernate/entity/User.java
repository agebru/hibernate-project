package com.hibernate.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

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
    @Column(name="user_id")
    private Long id;

    private String email;

    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

}
