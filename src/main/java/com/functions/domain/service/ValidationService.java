package com.functions.domain.service;

import com.functions.domain.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidationService<T> {

    private final Validator validator;

    public ValidationService() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public T validate(T request) throws ValidationException {

        if (request == null) {
            throw new ValidationException("The request body is required.");
        }

        Set<ConstraintViolation<T>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            String errorMessages = violations.stream()
                .map(this::getString)
                .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessages);
        }

        return request;
    }

    private String getString(ConstraintViolation<T> violation) {
        return "[" + violation.getPropertyPath() + "]: " + violation.getMessage();
    }
}
