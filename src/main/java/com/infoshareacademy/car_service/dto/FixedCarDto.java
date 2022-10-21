package com.infoshareacademy.car_service.dto;

import com.infoshareacademy.car_service.Model.Car;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FixedCarDto {

    private Long id;

    private LocalDateTime fixedDate;

    private Car car;
}
