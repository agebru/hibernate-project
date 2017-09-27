package com.hibernate.web.converter;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
public interface Converter<T, V> {

    T convertToEntity(V dto);

    V convertToDto(T entity);

}
