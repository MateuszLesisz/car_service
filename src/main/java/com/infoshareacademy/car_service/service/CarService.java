package com.infoshareacademy.car_service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.mapper.CarMapper;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private static final String CAR_REPOSITORY_JSON_FILE = "src/main/resources/carsForRepair.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();

//    public void saveToFile() {
////        Collection<Car> cars = carRepository.findAll();
//        try {
//            Writer writer = new FileWriter(CAR_REPOSITORY_JSON_FILE);
////            gson.toJson(cars, writer);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}