package com.infoshareacademy.car_service.exception.user;

import com.infoshareacademy.car_service.exception.CarServiceException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends CarServiceException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public UserAlreadyExistsException(String email) {
        super(String.format("User with this email already exist {email=%s}", email), DEFAULT_HTTP_STATUS);
    }
}