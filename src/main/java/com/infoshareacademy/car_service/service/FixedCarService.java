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
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class FixedCarService {
    private final FixedCarRepository fixedCarRepository;
    private static final String FIXED_CAR_REPOSITORY_JSON_FILE = "src/main/resources/fixed_cars/" + LocalDate.now() + " fixedCars.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();

    public void createFixedCar(BrokenCar brokenCar) {
        FixedCar fixedCar = FixedCar.builder()
                .fixedDate(LocalDateTime.now())
                .brokenCar(brokenCar)
                .build();

        fixedCarRepository.save(fixedCar);
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

    public List<FixedCar> getListOfReversedFixedCars() {
        List<FixedCar> fixedCars = fixedCarRepository.findAll();
        Collections.reverse(fixedCars);
        return fixedCars;
    }
}