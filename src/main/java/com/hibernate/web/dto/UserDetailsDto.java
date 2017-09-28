package com.hibernate.web.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ivanovaolyaa
 * @version 9/28/2017
 */
@Data
public class UserDetailsDto {

    @Pattern(regexp = "^\\d{10}$")
    private String identificationNumber;

    @Pattern(regexp = "^[A-Z]{2}\\d{6}$")
    private String passport;

}
