package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.Model.FixedCar;
import com.infoshareacademy.car_service.repository.FixedCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class FixedCarService {
    private final FixedCarRepository fixedCarRepository;
    private final BrokenCarService brokenCarService;

    public void createFixedCar(BrokenCar brokenCar) {
        FixedCar fixedCar = FixedCar.builder()
                .fixedDate(LocalDate.now())
                .brokenCar(brokenCar)
                .build();
        fixedCarRepository.save(fixedCar);
    }

    public void saveFixedCarById(Long id) {
        BrokenCar brokenCar = brokenCarService.changeIsFixedToTrue(id);
        createFixedCar(brokenCar);
    }

    public List<FixedCar> getListOfReversedFixedCars() {
        List<FixedCar> fixedCars = fixedCarRepository.findAll();
        Collections.reverse(fixedCars);
        return fixedCars;
    }
}