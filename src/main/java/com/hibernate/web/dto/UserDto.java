package com.hibernate.web.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

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

}
