package com.easy.tour.Tour_View.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotWhiteSpaceValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotWhiteSpace {
    String message() default "Your value must not contain whitespace";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
