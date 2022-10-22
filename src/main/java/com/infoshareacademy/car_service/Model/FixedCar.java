package com.infoshareacademy.car_service.Model;

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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fixedDate", nullable = false)
    private LocalDate fixedDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private BrokenCar brokenCar;

}