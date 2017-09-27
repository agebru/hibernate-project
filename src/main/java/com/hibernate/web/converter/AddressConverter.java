package com.hibernate.web.converter;

import com.hibernate.entity.Address;
import com.hibernate.web.dto.AddressDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
@Component
@Qualifier("addressConverter")
public class AddressConverter implements Converter<Address, AddressDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Address convertToEntity(final AddressDto dto) {
        return modelMapper.map(dto, Address.class);
    }

    @Override
    public AddressDto convertToDto(final Address entity) {
        return modelMapper.map(entity, AddressDto.class);
    }

}
