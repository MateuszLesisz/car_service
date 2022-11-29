package com.infoshareacademy.car_service.annotations.date;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = DateValidator.class
)
public @interface DateValidation {

    String message() default "Year must be less or equals current year and greater than 1900";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}