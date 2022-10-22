package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.FixedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedCarRepository extends JpaRepository<FixedCar, Long> {

}