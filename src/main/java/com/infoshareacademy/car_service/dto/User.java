package com.infoshareacademy.car_service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {

    private Long id;
    @NotBlank(message = "name field cannot be empty")
    private String name;
    @NotBlank(message = "lastname field cannot be empty")
    private String lastname;
    @NotBlank(message = "e-mail field cannot be empty")
    private String email;
    @NotBlank(message = "password field cannot be empty")
    private String password;
    @NotBlank(message = "city field cannot be empty")
    private String city;
    @NotBlank(message = "street field cannot be empty")
    private String street;
    @NotBlank(message = "house number field cannot be empty")
    private String houseNumber;
    @NotBlank(message = "zip code field cannot be empty")
    private int zipCode;

}