package com.infoshareacademy.car_service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.Model.FixedCar;
import com.infoshareacademy.car_service.dto.BrokenCarDto;
import com.infoshareacademy.car_service.repository.BrokenCarRepository;
import com.infoshareacademy.car_service.repository.FixedCarRepository;
import com.infoshareacademy.car_service.utils.GsonLocalDate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class BrokenCarService {

    private final BrokenCarRepository brokenCarRepository;
    private  final FixedCarService fixedCarService;
    private final FixedCarRepository fixedCarRepository;

    private static final String BROKEN_CAR_REPOSITORY_JSON_FILE = "src/main/resources/brokenCars.json";

    private static final String FIXED_CAR_REPOSITORY_JSON_FILE = "src/main/resources/fixed_cars/" + LocalDate.now() + " fixedCars.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();



    public void saveToFileBrokenCars() {
        Collection<BrokenCar> brokenCars = brokenCarRepository.findBrokenCarsByIsFixed(false);
        try {
            Writer writer = new FileWriter(BROKEN_CAR_REPOSITORY_JSON_FILE);
            gson.toJson(brokenCars, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveToFileFixedCars() {
        Collection<FixedCar> fixedCars = fixedCarRepository.findAll();
        try {
            Writer writer = new FileWriter(FIXED_CAR_REPOSITORY_JSON_FILE);
            gson.toJson(fixedCars, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

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

    public List<BrokenCar> getCarByRegistrationNumberAndIsFixed(String registrationNumber, boolean isFixed) {
        return brokenCarRepository.findBrokenCarByRegistrationNumberAndIsFixed(registrationNumber, isFixed);
    }

    public BrokenCar changeIsFixedToTrue(Long id) {
        BrokenCar brokenCar = brokenCarRepository.findById(id).orElseThrow();
        brokenCar.setIsFixed(true);
        brokenCar.setFixedDate(LocalDate.now());
        return brokenCarRepository.save(brokenCar);
    }

    public void saveFixedCarById(Long id) {
        BrokenCar brokenCar = changeIsFixedToTrue(id);
        fixedCarService.createFixedCar(brokenCar);
    }
}