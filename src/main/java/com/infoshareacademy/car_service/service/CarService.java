package com.infoshareacademy.car_service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.repository.CarRepository;
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
public class CarService {

    private final CarRepository carRepository;
    private static final String BROKEN_CAR_REPOSITORY_JSON_FILE = "src/main/resources/brokenCars.json";

    private static final String FIXED_CAR_REPOSITORY_JSON_FILE = "src/main/resources/fixed_cars/" + LocalDate.now() + " fixedCars.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();

    public void saveToFileBrokenCars() {
        Collection<Car> cars = carRepository.findCarsByIsFixed(false);
        try {
            Writer writer = new FileWriter(BROKEN_CAR_REPOSITORY_JSON_FILE);
            gson.toJson(cars, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveToFileFixedCars() {
        Collection<Car> cars = carRepository.findCarsByIsFixed(true);
        try {
            Writer writer = new FileWriter(FIXED_CAR_REPOSITORY_JSON_FILE);
            gson.toJson(cars, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createCar(CarDto carDto) {
        Car car = Car.builder()
                .registrationNumber(carDto.getRegistrationNumber())
                .name(carDto.getName())
                .color(carDto.getColor())
                .yearOfProduction(carDto.getYearOfProduction())
                .dateOfAddCar(LocalDate.now())
                .isFixed(false)
                .fixedDate(carDto.getFixedDate())
                .build();
        carRepository.save(car);
    }

    public List<Car> getListOfBrokenCars() {
        return carRepository.findCarsByIsFixed(false);
    }

    public List<Car> getListOfFixedCars() {
        List<Car> cars = carRepository.findCarsByIsFixed(true);
        Collections.sort(cars, Comparator.comparing(Car::getFixedDate).reversed());
        return cars;
    }

    public Car changeIsFixedToTrue(Long id) {
        Car car = carRepository.findById(id).orElseThrow();
        car.setIsFixed(true);
        car.setFixedDate(LocalDate.now());
        return carRepository.save(car);
    }

    public List<Car> getCarByRegistrationNumberAndIsFixed(String registrationNumber, boolean isFixed) {
        return carRepository.findCarByRegistrationNumberAndIsFixed(registrationNumber, isFixed);
    }
}