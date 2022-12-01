package com.infoshareacademy.car_service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmailConformationDto {

    private Long id;
    @NotNull
    private Boolean active;
}
