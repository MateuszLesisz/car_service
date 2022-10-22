package com.infoshareacademy.car_service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.Model.FixedCar;
import com.infoshareacademy.car_service.repository.FixedCarRepository;
import com.infoshareacademy.car_service.utils.GsonLocalDate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class FixedCarService {
    private final FixedCarRepository fixedCarRepository;




    public void createFixedCar(BrokenCar brokenCar) {
        FixedCar fixedCar = FixedCar.builder()
                .fixedDate(LocalDate.now())
                .brokenCar(brokenCar)
                .build();

        fixedCarRepository.save(fixedCar);
    }





    public List<FixedCar> getListOfReversedFixedCars() {
        List<FixedCar> fixedCars = fixedCarRepository.findAll();
        Collections.reverse(fixedCars);
        return fixedCars;
    }
}