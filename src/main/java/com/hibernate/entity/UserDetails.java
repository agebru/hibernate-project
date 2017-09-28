package com.hibernate.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ivanovaolyaa
 * @version 8/17/2017
 */
@Entity
@Table(name = "user_details")
@Getter
@Setter
@EqualsAndHashCode
public class UserDetails {

    /** Compound Primary Key: Country + ID */
    @EmbeddedId
    private UserId userId;

    @Column(name = "id_number")
    private String identificationNumber;

    @Embedded
    private Passport passport;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({  // User class has composite primary key
            @JoinColumn(name = "user_id"),
            @JoinColumn(name = "country")
    })
    @MapsId
    @JsonIgnore
    private User user;

}
