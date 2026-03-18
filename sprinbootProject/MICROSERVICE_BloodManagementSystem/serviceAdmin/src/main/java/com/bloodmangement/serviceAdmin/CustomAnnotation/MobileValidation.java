package com.bloodmangement.serviceAdmin.CustomAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileValidation implements ConstraintValidator<MobileNo, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null) {
            return false;   // or return true if null is allowed
        }

        return value.matches("^[0-9]{10}$");
    }
}
