package com.infoshareacademy.car_service.Model;

import com.infoshareacademy.car_service.dto.Color;
import com.infoshareacademy.car_service.entity.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class Car implements Entity<Long> {

    private Long id;
    private String registrationNumber;
    private String name;
    private Color color;
    private Integer yearOfProduction;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate today;
    private Boolean isFixed;

}
