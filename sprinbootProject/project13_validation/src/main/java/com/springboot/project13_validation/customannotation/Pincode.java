package com.springboot.project13_validation.customannotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PincodeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Pincode {

    String message() default "Invalid Indian PIN code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}