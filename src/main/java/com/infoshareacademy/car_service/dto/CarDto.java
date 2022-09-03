package com.infoshareacademy.car_service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
public class CarDto {

    private Long id;
    @NotBlank
    private String registrationNumber;
    @NotBlank
    private String name;
    @NotNull
    private Color color;
    @NotNull
    private Integer yearOfProduction;
    private LocalDate today;
    private Boolean isFixed;
}
