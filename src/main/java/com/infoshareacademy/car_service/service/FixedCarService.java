package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.Model.FixedCar;
import com.infoshareacademy.car_service.repository.FixedCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FixedCarService {

    private final FixedCarRepository fixedCarRepository;

    public void createFixedCar(Car car) {
        FixedCar fixedCar = FixedCar.builder()
                .fixedDate(LocalDateTime.now())
                .car(car)
                .build();
        fixedCarRepository.save(fixedCar);
    }
}