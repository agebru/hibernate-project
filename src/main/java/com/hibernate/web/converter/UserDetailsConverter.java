package com.hibernate.web.converter;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.hibernate.entity.Passport;
import com.hibernate.entity.UserDetails;
import com.hibernate.web.dto.UserDetailsDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author ivanovaolyaa
 * @version 9/28/2017
 */
@Component
@Qualifier("userDetailsConverter")
public class UserDetailsConverter implements Converter<UserDetails, UserDetailsDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails convertToEntity(final UserDetailsDto dto) {
        final UserDetails userDetails = modelMapper.map(dto, UserDetails.class);
        userDetails.setPassport(parsePassportData(dto.getPassport()));

        return userDetails;
    }

    @Override
    public UserDetailsDto convertToDto(final UserDetails entity) {
        final UserDetailsDto userDetailsDto = modelMapper.map(entity, UserDetailsDto.class);
        userDetailsDto.setPassport(parsePassport(entity.getPassport()));

        return userDetailsDto;
    }

    private Passport parsePassportData(final String data) {
        if (Objects.nonNull(data)) {
            Passport passport = new Passport();

            Pattern pattern = Pattern.compile("^([A-Z]{2})(\\d{6})$");
            Matcher matcher = pattern.matcher(data);

            if (matcher.find()) {
                passport.setSeries(matcher.group(1));
                passport.setNumber(matcher.group(2));
            }

            return passport;
        }

        return null;
    }

    private String parsePassport(final Passport passport) {
        return Joiner.on("").join(passport.getSeries(), passport.getNumber());
    }

}
