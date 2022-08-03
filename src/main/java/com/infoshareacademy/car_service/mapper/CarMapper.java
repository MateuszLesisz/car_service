package com.infoshareacademy.car_service.mapper;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setColor(car.getColor());
        carDto.setName(car.getName());
        carDto.setToday(car.getToday());
        carDto.setIsFixed(car.getIsFixed());
        carDto.setRegistrationNumber(car.getRegistrationNumber());
        carDto.setYearOfProduction(car.getYearOfProduction());
        return carDto;
    }

    public Car toEntity(CarDto carDto) {
        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setName(carDto.getName());
        car.setToday(carDto.getToday());
        car.setRegistrationNumber(carDto.getRegistrationNumber());
        car.setIsFixed(carDto.getIsFixed());
        car.setYearOfProduction(car.getYearOfProduction());
        return car;
    }
}
