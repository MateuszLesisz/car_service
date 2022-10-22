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
    private LocalDate dateOfAddCar;

    @Column(name = "fixed", nullable = false)
    private Boolean isFixed;

    @Column(name = "fixedDate")
    private LocalDate fixedDate;

}