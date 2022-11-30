package com.infoshareacademy.car_service.model;

import com.infoshareacademy.car_service.dto.Color;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrokenCar {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String registrationNumber;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column
    @NotNull
    private Integer yearOfProduction;

    @Column
    @NotNull
    private LocalDate dateOfAddCar;

    @Column
    @NotNull
    private Boolean isFixed;

    @Column
    private LocalDate fixedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}