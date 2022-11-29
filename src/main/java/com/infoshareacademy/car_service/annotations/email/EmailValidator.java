package com.infoshareacademy.car_service.annotations.email;

import com.infoshareacademy.car_service.model.User;
import com.infoshareacademy.car_service.repository.UserRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@AllArgsConstructor
public class EmailValidator implements ConstraintValidator<EmailValidation, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Optional<User> user = userRepository.findUserByEmail(email);

        return user.isEmpty();
    }
}