package com.sewingfactory.utils;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class EntityValidation<T> {
    public EntityValidation() {}

    public ValidationResponse validate(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(entity);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Грешки: \n");
            for (ConstraintViolation<T> violation : violations) {
                errorMessage.append(violation.getPropertyPath()).append(" ")
                            .append(violation.getMessage()).append("\n");
            }
            return new ValidationResponse(true, errorMessage.toString());
        }

        return new ValidationResponse(false);
    }
}
