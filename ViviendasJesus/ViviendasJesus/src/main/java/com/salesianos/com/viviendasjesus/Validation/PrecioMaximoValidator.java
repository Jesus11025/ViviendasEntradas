package com.salesianos.com.viviendasjesus.Validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrecioMaximoValidator implements ConstraintValidator<PrecioMaximo, Integer> {

    private int maxValue;

    @Override
    public void initialize(PrecioMaximo constraintAnnotation) {
        this.maxValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value <= maxValue;
    }
}
