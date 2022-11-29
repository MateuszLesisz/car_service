package com.infoshareacademy.car_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CarServiceException extends RuntimeException{

    private final HttpStatus httpStatus;

    protected CarServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }

    HttpStatus getHttpStatus() {
        return httpStatus;
    }
}