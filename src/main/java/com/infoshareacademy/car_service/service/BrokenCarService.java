package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.dto.BrokenCarDto;
import com.infoshareacademy.car_service.repository.BrokenCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BrokenCarService {

    private final BrokenCarRepository brokenCarRepository;

    public void createCar(BrokenCarDto brokenCarDto) {
        BrokenCar brokenCar = BrokenCar.builder()
                .registrationNumber(brokenCarDto.getRegistrationNumber())
                .name(brokenCarDto.getName())
                .color(brokenCarDto.getColor())
                .yearOfProduction(brokenCarDto.getYearOfProduction())
                .dateOfAddCar(LocalDate.now())
                .isFixed(false)
                .fixedDate(brokenCarDto.getFixedDate())
                .build();
        brokenCarRepository.save(brokenCar);
    }

    public List<BrokenCar> getCarByRegistrationNumberAndIsFixed(String registrationNumber) {
        return brokenCarRepository.findBrokenCarByRegistrationNumber(registrationNumber);
    }

    public BrokenCar changeIsFixedToTrue(Long id) {
        BrokenCar brokenCar = brokenCarRepository.findById(id).orElseThrow();
        brokenCar.setIsFixed(true);
        brokenCar.setFixedDate(LocalDate.now());
        return brokenCarRepository.save(brokenCar);
    }
}