package com.infoshareacademy.car_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private Long id;
    private String registrationNumber;
    private String name;
    private Color color;
    private Integer yearOfProduction;
    private LocalDate today;
    private Boolean isFixed;
}
