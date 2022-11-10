package com.infoshareacademy.car_service.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
public class BrokenCarDto {

    private Long id;
    @NotBlank(message = "Registration number field cannot be empty")
    @Size(min = 7, message = "registration number is too short")
    private String registrationNumber;
    @NotBlank(message = "name field cannot be empty")
    @Size(min = 2, message = "name is too short")
    private String name;
    private Color color;
    @NotNull(message = "year of production field cannot be empty")
    @Max(2022)
    @Min(1800)
    private Integer yearOfProduction;
    private LocalDate dateOfAddCar;
    private Boolean isFixed;
    private LocalDate fixedDate;
}