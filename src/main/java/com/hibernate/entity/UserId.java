package com.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ivanovaolyaa
 * @version 9/22/2017
 */
@Getter
// Note that there are no setter methods. Once it has been constructed using the PK values, it can’t be changed.
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserId implements Serializable {

    private String country;

    private Long id;

}
