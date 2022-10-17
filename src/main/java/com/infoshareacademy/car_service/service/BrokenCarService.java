package com.infoshareacademy.car_service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.dto.BrokenCarDto;
import com.infoshareacademy.car_service.repository.BrokenCarRepository;
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

    private static final String CAR_REPOSITORY_JSON_FILE = "src/main/resources/carsForRepair.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();

    public void saveToFile() {
        Collection<BrokenCar> brokenCars = brokenCarRepository.findAll();
        try {
            Writer writer = new FileWriter(CAR_REPOSITORY_JSON_FILE);
            gson.toJson(brokenCars, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BrokenCar createBrokenCar(BrokenCarDto brokenCarDto) {
        BrokenCar brokenCar = BrokenCar.builder()
                .registrationNumber(brokenCarDto.getRegistrationNumber())
                .name(brokenCarDto.getName())
                .color(brokenCarDto.getColor())
                .yearOfProduction(brokenCarDto.getYearOfProduction())
                .today(LocalDate.now())
                .isFixed(false)
                .build();
        return brokenCarRepository.save(brokenCar);
    }

    public List<BrokenCar> getListOfBrokenCars(Boolean isFixed) {
        return brokenCarRepository.findCarsByIsFixed(isFixed);
    }

    public List<BrokenCar> getListOfFixedCars(Boolean isFixed) {
        return brokenCarRepository.findCarsByIsFixed(isFixed);
    }

    public BrokenCar changeIsFixedToTrue(Long id) {
        BrokenCar brokenCar = brokenCarRepository.findById(id).orElseThrow();
        brokenCar.setIsFixed(true);
        return brokenCarRepository.save(brokenCar);
    }

    public List<BrokenCar> getCarByRegistrationNumber(String registrationNumber) {
        return brokenCarRepository.findCarByRegistrationNumber(registrationNumber);
    }

    public void deleteFromBrokenCars(Long id) {
        brokenCarRepository.delete(getBrokenCarById(id));
    }
    private BrokenCar getBrokenCarById(Long id) {
        return brokenCarRepository.findById(id).orElseThrow();
    }
}