package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.Color;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CarRepository extends FakeRepository<Long, Car> {

    private final AtomicLong nextId = new AtomicLong(1L);

    @PostConstruct
    public void initDb() {

        Car threads = new Car();
        threads.setName("VW");
        threads.setColor("blue");
        threads.setIsFixed(false);
        threads.setYearOfProduction(1998);
        threads.setRegistrationNumber("TKI 80C3");
        threads.setToday(LocalDate.now());

        save(threads);
    }

    @Override
    Long nextId() {
        return nextId.getAndIncrement();
    }
}