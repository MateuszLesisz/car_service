package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.Model.FixedCar;
import com.infoshareacademy.car_service.repository.FixedCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FixedCarService {
    private final FixedCarRepository fixedCarRepository;

    public void createFixedCar(BrokenCar brokenCar) {
        FixedCar fixedCar = FixedCar.builder()
                .fixedDate(LocalDateTime.now())
                .brokenCar(brokenCar)
                .build();
        fixedCarRepository.save(fixedCar);
    }
}