package com.infoshareacademy.car_service.annotations.username;

import com.infoshareacademy.car_service.annotations.email.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = UsernameValidator.class
)
public @interface UsernameValidation {

    String message() default "User with this username already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
