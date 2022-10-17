package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.Model.BrokenCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrokenCarRepository extends JpaRepository<BrokenCar, Long> {

    List<BrokenCar> findCarsByIsFixed(Boolean isFixed);

    @Query(value = "SELECT * FROM broken_car c WHERE registration_number LIKE %:keyword%", nativeQuery = true)
    List<BrokenCar> findCarByRegistrationNumber(@Param("keyword") String keyword);

}