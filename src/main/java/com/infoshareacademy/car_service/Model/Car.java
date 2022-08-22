package com.infoshareacademy.car_service.Model;

import com.infoshareacademy.car_service.dto.Color;
import com.infoshareacademy.car_service.entity.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Car implements Entity<Long> {

    private Long id;
    private String registrationNumber;
    private String name;
    private Color color;
    private Integer yearOfProduction;
    private LocalDate today;
    private Boolean isFixed;

}
