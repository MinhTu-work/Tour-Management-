package com.easy.tour.Tour_View.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotWhiteSpaceValidator implements ConstraintValidator<NotWhiteSpace, String> {
    @Override
    public void initialize(NotWhiteSpace constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // @NotEmpty sẽ xử lý null
        }
        return value.equals(value.trim());
    }
}
