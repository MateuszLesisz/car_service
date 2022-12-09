package com.infoshareacademy.car_service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleDto {

    @NotNull(message = "name field cannot be null")
    private String name;
}
