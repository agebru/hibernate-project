package com.hibernate.web.exception;

/**
 * @author ivanovaolyaa
 * @version 9/27/2017
 */
public class DuplicateEmailException extends Throwable {

    public DuplicateEmailException(final String message) {
        super(message);
    }

}
