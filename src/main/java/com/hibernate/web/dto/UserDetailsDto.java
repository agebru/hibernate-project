package com.hibernate.web.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @author ivanovaolyaa
 * @version 9/28/2017
 */
@Data
public class UserDetailsDto {

    @Pattern(regexp = "^\\d{10}$")
    private String identificationNumber;

}
