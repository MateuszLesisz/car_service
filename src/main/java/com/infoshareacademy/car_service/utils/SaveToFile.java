package com.infoshareacademy.car_service.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.model.BrokenCar;
import com.infoshareacademy.car_service.model.FixedCar;
import com.infoshareacademy.car_service.repository.BrokenCarRepository;
import com.infoshareacademy.car_service.repository.FixedCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Collection;

@AllArgsConstructor
@Component
public class SaveToFile {

    private final BrokenCarRepository brokenCarRepository;
    private final FixedCarRepository fixedCarRepository;

    private static final String BROKEN_CAR_REPOSITORY_JSON_FILE = "src/main/resources/cars.json";
    private static final String FIXED_CAR_REPOSITORY_JSON_FILE = "src/main/resources/fixed_cars/" + LocalDate.now() + " fixedCars.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();

    public void saveToFileBrokenCars() {
        Collection<BrokenCar> brokenCars = brokenCarRepository.findAll();
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
        Collection<FixedCar> fixedCars = fixedCarRepository.findFixedCarByFixedDate(LocalDate.now());
        try {
            Writer writer = new FileWriter(FIXED_CAR_REPOSITORY_JSON_FILE);
            gson.toJson(fixedCars, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
