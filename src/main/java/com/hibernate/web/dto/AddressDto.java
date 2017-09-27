package com.hibernate.web.dto;

import lombok.Data;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Data
public class AddressDto {

    private String city;

    private String street;

    private String streetNumber;

    private String flatNumber;

    private String postalCode;

}
