package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByIsFixed(Boolean isFixed);

    @Query(value = "SELECT * FROM car c WHERE c_registration_number LIKE %:keyword%", nativeQuery = true)
    List<Car> findCarByRegistrationNumber(@Param("keyword") String keyword);

}