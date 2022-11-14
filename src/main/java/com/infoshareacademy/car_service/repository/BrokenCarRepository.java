package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.BrokenCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrokenCarRepository extends JpaRepository<BrokenCar, Long> {

    List<BrokenCar> findBrokenCarsByIsFixed(Boolean isFixed);

    List<BrokenCar> findBrokenCarByRegistrationNumberAndIsFixed(String registrationNumber, boolean isFixed);
}