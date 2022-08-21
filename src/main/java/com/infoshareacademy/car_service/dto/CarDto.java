package com.infoshareacademy.car_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
public class CarDto {

    private Long id;
    @NotBlank
    private String registrationNumber;
    @NotBlank
    private String name;
    @NotBlank
    private String color;
    @NotNull
    private Integer yearOfProduction;
    private LocalDate today;
    private Boolean isFixed;
}
