package com.infoshareacademy.car_service.annotations.email;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = EmailValidator.class
)
public @interface EmailValidation {

    String message() default "User with this email already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}