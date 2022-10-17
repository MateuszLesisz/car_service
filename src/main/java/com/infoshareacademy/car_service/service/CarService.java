package com.infoshareacademy.car_service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.repository.CarRepository;
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
public class CarService {

    private final CarRepository carRepository;

    private static final String CAR_REPOSITORY_JSON_FILE = "src/main/resources/carsForRepair.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();

    public void saveToFile() {
        Collection<BrokenCar> brokenCars = carRepository.findAll();
        try {
            Writer writer = new FileWriter(CAR_REPOSITORY_JSON_FILE);
            gson.toJson(brokenCars, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BrokenCar createCar(CarDto carDto) {
        BrokenCar brokenCar = BrokenCar.builder()
                .registrationNumber(carDto.getRegistrationNumber())
                .name(carDto.getName())
                .color(carDto.getColor())
                .yearOfProduction(carDto.getYearOfProduction())
                .today(LocalDate.now())
                .isFixed(false)
                .build();
        return carRepository.save(brokenCar);
    }

    public List<BrokenCar> getListOfBrokenCars(Boolean isFixed) {
        return carRepository.findCarsByIsFixed(isFixed);
    }

    public List<BrokenCar> getListOfFixedCars(Boolean isFixed) {
        return carRepository.findCarsByIsFixed(isFixed);
    }

    public BrokenCar changeIsFixedToTrue(Long id) {
        BrokenCar brokenCar = carRepository.findById(id).orElseThrow();
        brokenCar.setIsFixed(true);
        return carRepository.save(brokenCar);
    }

    public List<BrokenCar> getCarByRegistrationNumber(String registrationNumber) {
        return carRepository.findCarByRegistrationNumber(registrationNumber);
    }
}