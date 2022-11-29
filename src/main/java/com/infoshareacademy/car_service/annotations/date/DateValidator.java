package com.infoshareacademy.car_service.annotations.date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<DateValidation, Integer> {

    public static final Integer BASE_YEAR = 1900;

    @Override
    public boolean isValid(Integer currentYear, ConstraintValidatorContext context) {
        if (currentYear == null) {
            return false;
        }
        return currentYear <= LocalDate.now().getYear() && currentYear >= BASE_YEAR;
    }
}