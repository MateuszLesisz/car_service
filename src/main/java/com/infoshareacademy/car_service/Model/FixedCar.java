package com.infoshareacademy.car_service.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = Car.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
public class FixedCar {

    public static final String TABLE_NAME = "fixed_car";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fixedDate", nullable = false)
    private LocalDateTime fixedDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}