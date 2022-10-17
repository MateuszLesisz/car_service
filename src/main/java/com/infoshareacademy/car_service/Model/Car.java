package com.infoshareacademy.car_service.Model;

import com.infoshareacademy.car_service.dto.Color;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "today", nullable = false)
    private LocalDate today;

    @Column(name = "fixed", nullable = false)
    private Boolean isFixed;

    public Car(String registrationNumber, String name, Color color, Integer yearOfProduction, LocalDate today, Boolean isFixed) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
        this.today = today;
        this.isFixed = isFixed;
    }
}
