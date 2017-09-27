package com.hibernate.web.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Data
public class UserDto {

    @Pattern(regexp = "^[A-Z]{2}$")
    private String country;

    private String email;

    private String password;

    private String confirmPassword;

    @JsonProperty("role")
    private String roleName;

}
