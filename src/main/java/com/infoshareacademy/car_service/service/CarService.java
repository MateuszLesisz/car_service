package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.mapper.CarMapper;
import com.infoshareacademy.car_service.repository.CarRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CarService {

private final CarRepository carRepository;
private final CarMapper mapper;

    public CarService(CarRepository carRepository, CarMapper mapper) {
        this.carRepository = carRepository;
        this.mapper = mapper;
    }

    public void create(CarDto carDto) {
    Car car = mapper.toEntity(carDto);
    carRepository.save(car);
    }

    public CarDto find(Long id) {
        Car car = carRepository.findById(id);
        return mapper.toDto(car);
    }
}
