package com.infoshareacademy.car_service.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
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