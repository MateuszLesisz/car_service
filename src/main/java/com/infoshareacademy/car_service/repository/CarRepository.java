package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.Car;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CarRepository extends FakeRepository<Long, Car> {

    private final AtomicInteger nextId = new AtomicInteger();
    private final AtomicInteger nextElementId = new AtomicInteger();

    @PostConstruct
    public void initDb() {

    }

    public void save(Car entity) {
        entity.getElements().forEach(e ->  {
            if(e.getId() == null) {
                e.setId((long) nextElementId.getAndIncrement());
            }
        });
        super.save(entity);
    }

    @Override
    Long nextId() {
        return (long) nextId.getAndIncrement();
    }
}
