package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.mapper.CarMapper;
import com.infoshareacademy.car_service.repository.CarRepository;
import com.infoshareacademy.car_service.utils.Can;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper mapper;

    public void create(CarDto carDto) {
        carDto.setToday(LocalDate.now());
        Car car = mapper.toEntity(carDto);
        carRepository.save(car);
        Can.saveToFile(car);
    }

    public CarDto find(Long id) {
        Car car = carRepository.findById(id);
        return mapper.toDto(car);
    }

    public List<CarDto> findAll() {
        Collection<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}