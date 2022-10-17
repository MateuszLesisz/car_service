package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.Model.FixedCar;
import com.infoshareacademy.car_service.dto.BrokenCarDto;
import com.infoshareacademy.car_service.dto.FixedCarDto;
import com.infoshareacademy.car_service.repository.FixedCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FixedCarService {

    private final FixedCarRepository fixedCarRepository;

    public FixedCar createFixedCar(FixedCarDto fixedCarDto) {
        FixedCar fixedCar = FixedCar.builder()
                .id(fixedCarDto.getId())
                .brokenId(fixedCarDto.getBrokenId())
                .isFixed(fixedCarDto.isFixed())
                .build();
        return fixedCarRepository.save(fixedCar);
    }
}
