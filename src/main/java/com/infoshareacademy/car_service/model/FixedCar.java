package com.infoshareacademy.car_service.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedCar {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate fixedDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private BrokenCar brokenCar;

}