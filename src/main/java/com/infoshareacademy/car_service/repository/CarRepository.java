package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByIsFixed(Boolean isFixed);

    Car findByRegistrationNumber(String registrationNumber);

}