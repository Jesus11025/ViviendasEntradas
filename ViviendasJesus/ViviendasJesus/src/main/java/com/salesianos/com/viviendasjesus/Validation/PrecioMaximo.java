package com.salesianos.com.viviendasjesus.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PrecioMaximoValidator.class)
@Documented
public @interface PrecioMaximo {

    String message() default "El precio supera el máximo permitido de 1.000.000";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int value() default 1_000_000;
}