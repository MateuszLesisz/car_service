package com.infoshareacademy.car_service.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.utils.GsonLocalDate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CarRepository extends FakeRepository<Long, Car> {

    private static final String CAR_REPOSITORY_JSON_FILE = "src/main/resources/carsForRepair.json";
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new GsonLocalDate()).setPrettyPrinting().create();
    private final AtomicLong nextId = new AtomicLong();

    @PostConstruct
    public void initDb() {
        try {
            loadFromFile();
        } catch (NullPointerException e) {
            System.out.println("file is empty");
        }
    }

    @Override
    Long nextId() {
        return nextId.addAndGet(fakeDb.size() + 1L);
    }

    public void loadFromFile() {
        try {
            Reader reader = new FileReader(CAR_REPOSITORY_JSON_FILE);
            List<Car> cars = gson.fromJson(reader, new TypeToken<ArrayList<Car>>() {
            }.getType());
            cars.forEach(car -> fakeDb.put(car.getId(), car));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}