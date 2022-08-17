package com.infoshareacademy.car_service.Model;

import com.infoshareacademy.car_service.dto.Color;
import com.infoshareacademy.car_service.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Car implements Entity<Long> {

    private Long id;
    private String registrationNumber;
    private String name;
    private String color;
    private Integer yearOfProduction;
    private LocalDate today;
    private Boolean isFixed;

}
