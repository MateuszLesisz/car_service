package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.dto.EmailConformationDto;
import com.infoshareacademy.car_service.model.EmailConfirmation;
import com.infoshareacademy.car_service.repository.EmailConfirmationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailConfirmationService {

    private final EmailConfirmationRepository emailConfirmationRepository;

    public void createEmailConfirmation(EmailConformationDto emailConformationDto) {
        EmailConfirmation emailConfirmation = EmailConfirmation.builder()
                .active(emailConformationDto.getActive())
                .build();
        emailConfirmationRepository.save(emailConfirmation);
    }
}