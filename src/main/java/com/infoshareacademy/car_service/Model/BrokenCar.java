package com.infoshareacademy.car_service.Model;

import com.infoshareacademy.car_service.dto.Color;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrokenCar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column(name = "registration_number", nullable = false)
    @Setter
    private String registrationNumber;

    @Column(name = "name", nullable = false)
    @Setter
    private String name;

    @Column(name = "color", nullable = false)
    @Setter
    private Color color;

    @Column(name = "year_of_production", nullable = false)
    @Setter
    private Integer yearOfProduction;

    @Column(name = "dateOfAddCar", nullable = false)
    @Setter
    private LocalDate dateOfAddCar;

    @Column(name = "fixed", nullable = false)
    @Setter
    private Boolean isFixed;

    @Column(name = "fixedDate")
    @Setter
    private LocalDate fixedDate;

    public BrokenCar(String registrationNumber, String name, Color color, Integer yearOfProduction, LocalDate dateOfAddCar, Boolean isFixed, LocalDate fixedDate) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
        this.dateOfAddCar = dateOfAddCar;
        this.isFixed = isFixed;
        this.fixedDate = fixedDate;
    }
}