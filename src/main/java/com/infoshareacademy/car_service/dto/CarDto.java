package com.infoshareacademy.car_service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class CarDto {

    private Long id;
    @NotBlank(message = "Registration number field cannot be empty")
    private String registrationNumber;
    @NotBlank(message = "name field cannot be empty")
    private String name;
    private Color color;
    @NotNull(message = "year of production field cannot be empty")
    private Integer yearOfProduction;
    private LocalDateTime dateOfAddCar;
    private Boolean isFixed;
    private LocalDateTime fixedDate;
}
