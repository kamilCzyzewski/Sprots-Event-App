package com.event.app.sports.annotation;

import com.event.app.sports.annotation.validator.AgeConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;

@Constraint(validatedBy = AgeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

    int valueMin() default 0;

    int valueMax() default 120;

    String message() default "Wiek niewłaściwy";

    Class<?>[] groups() default {};

    Class <? extends Payload>[] payload() default{};
}
