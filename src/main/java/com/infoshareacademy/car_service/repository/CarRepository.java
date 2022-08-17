package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.Car;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CarRepository extends FakeRepository<Long, Car> {

    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    Long nextId() {
        return nextId.getAndIncrement();
    }
}