package com.infoshareacademy.car_service.dto;

import com.infoshareacademy.car_service.annotations.date.DateValidation;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
public class BrokenCarDto {
    @NotBlank(message = "Registration number field cannot be empty")
    @Size(min = 7, message = "registration number is too short")
    private String registrationNumber;
    @NotBlank(message = "name field cannot be empty")
    @Size(min = 2, message = "name is too short")
    private String name;
    private Color color;
    @NotNull(message = "year of production field cannot be empty")
    @DateValidation
    private Integer yearOfProduction;
    private LocalDate dateOfAddCar;
    private Boolean isFixed;
    private LocalDate fixedDate;
}