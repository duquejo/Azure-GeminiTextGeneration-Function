package com.functions.application.validation;


import com.functions.domain.model.RequestModel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidateRequest {

    private ValidateRequest() {}

    public static RequestModel validate(RequestModel request) throws ValidationException {

        if( request == null ) {
            throw new ValidationException("The request body is required.");
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<RequestModel>> violations = validator.validate(request);
        if( ! violations.isEmpty() ) {
            String errorMessages = violations.stream()
                .map(ValidateRequest::getString)
                .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessages);
        }

        return request;
    }

    private static String getString(ConstraintViolation<RequestModel> violation) {
        return "[" + violation.getPropertyPath() + "]: " + violation.getMessage();
    }
}
