package com.springboot.project13_validation.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PincodeValidator implements ConstraintValidator<Pincode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;   // or return true if null is allowed
        }

        return value.matches("^[1-9][0-9]{5}$");
    }
}