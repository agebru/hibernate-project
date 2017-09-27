package com.hibernate.web.converter;

import com.hibernate.entity.User;
import com.hibernate.web.dto.UserDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Component
public class UserConverter<T, V> implements Converter<User, UserDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User convertToEntity(final UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserDto convertToDto(final User entity) {
        return modelMapper.map(entity, UserDto.class);
    }

}
