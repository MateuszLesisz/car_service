package com.infoshareacademy.car_service.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Can {
    public static void saveToFile(Car car) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("src/main/resources/carsForRepair.json");
            gson.toJson(car, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}