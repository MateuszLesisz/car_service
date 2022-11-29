package com.infoshareacademy.car_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CarServiceException.class)
    ResponseEntity<ErrorResponse> handleBusinessException(CarServiceException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(ErrorResponse.builder()
                        .statusCode(exception.getHttpStatus().value())
                        .message(exception.getMessage())
                        .build());
    }
}