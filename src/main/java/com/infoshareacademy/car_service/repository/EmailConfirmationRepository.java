package com.infoshareacademy.car_service.repository;

import com.infoshareacademy.car_service.model.EmailConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailConfirmationRepository extends JpaRepository<EmailConfirmation, Long> {
}
