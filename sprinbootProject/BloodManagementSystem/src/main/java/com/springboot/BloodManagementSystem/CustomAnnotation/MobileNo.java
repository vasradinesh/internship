package com.springboot.BloodManagementSystem.CustomAnnotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
//MobileNo
@Documented
@Constraint(validatedBy = MobileValidation.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNo {

    String message() default "enter valid mobile no";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}