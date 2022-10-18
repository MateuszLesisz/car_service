package com.infoshareacademy.car_service.Model;

import com.infoshareacademy.car_service.dto.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = Car.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    public static final String TABLE_NAME = "car";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "color", nullable = false)
    private Color color;

    @Column(name = "year_of_production", nullable = false)
    private Integer yearOfProduction;

    @Column(name = "dateOfAddCar", nullable = false)
    private LocalDateTime dateOfAddCar;

    @Column(name = "fixed", nullable = false)
    private Boolean isFixed;

    @Column(name = "fixedDate")
    private LocalDateTime fixedDate;

    public Car(String registrationNumber, String name, Color color, Integer yearOfProduction, LocalDateTime dateOfAddCar, Boolean isFixed, LocalDateTime fixedDate) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
        this.dateOfAddCar = dateOfAddCar;
        this.isFixed = isFixed;
        this.fixedDate = fixedDate;

    }
}
