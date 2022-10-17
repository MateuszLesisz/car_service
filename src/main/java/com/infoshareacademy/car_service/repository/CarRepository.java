package com.infoshareacademy.car_service.repository;

<<<<<<< HEAD
import com.infoshareacademy.car_service.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

=======
import com.infoshareacademy.car_service.Model.BrokenCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
>>>>>>> parent of 5c20e85 (Add FixedCar necessary classes and delate fixed car from broken table)
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
<<<<<<< HEAD
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByIsFixed(Boolean isFixed);

    List<Car> findCarByRegistrationNumberAndIsFixed(String registrationNumber, boolean isFixed);
=======
public interface CarRepository extends JpaRepository<BrokenCar, Long> {

    List<BrokenCar> findCarsByIsFixed(Boolean isFixed);

    @Query(value = "SELECT * FROM broken_car c WHERE bc_registration_number LIKE %:keyword%", nativeQuery = true)
    List<BrokenCar> findCarByRegistrationNumber(@Param("keyword") String keyword);
>>>>>>> parent of 5c20e85 (Add FixedCar necessary classes and delate fixed car from broken table)

}