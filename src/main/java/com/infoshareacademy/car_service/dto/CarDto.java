package com.infoshareacademy.car_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
public class CarDto {

    private Long id;
    @NotNull
    private String registrationNumber;
    @NotNull
    private String name;
    @NotNull
    private String color;
    @NotNull
    private Integer yearOfProduction;
    private LocalDate today;
    private Boolean isFixed;
}
