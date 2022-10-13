package com.infoshareacademy.car_service.Model;

import com.infoshareacademy.car_service.dto.Color;
import lombok.*;

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
    public static final String COLUMN_PREFIX = "c_";

    @Id
    @Column(name = COLUMN_PREFIX + "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = COLUMN_PREFIX + "registration_number", nullable = false)
    private String registrationNumber;

    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @Column(name = COLUMN_PREFIX + "color", nullable = false)
    private Color color;

    @Column(name = COLUMN_PREFIX + "year_of_production", nullable = false)
    private Integer yearOfProduction;

    @Column(name = COLUMN_PREFIX + "today", nullable = false)
    private LocalDate today;

    @Column(name = COLUMN_PREFIX + "is_fixed", nullable = false)
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
