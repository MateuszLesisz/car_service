package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.CarForRepair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarForRepair, Long> {


}
