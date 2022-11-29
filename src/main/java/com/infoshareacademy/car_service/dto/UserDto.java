package com.infoshareacademy.car_service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    private Long id;
    @NotBlank(message = "username field cannot be empty")
    private String username;
    @NotBlank(message = "e-mail field cannot be empty")
    private String email;
    @NotBlank(message = "password field cannot be empty")
    private String password;
    @NotNull(message = "phone field cannot be null")
    private int phoneNumber;
}