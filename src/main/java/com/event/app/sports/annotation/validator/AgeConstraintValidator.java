package com.event.app.sports.annotation.validator;

import com.event.app.sports.annotation.Age;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class AgeConstraintValidator implements ConstraintValidator<Age, Integer> {

    private int min;
    private int max;

    @Override
    public void initialize(Age age) {
        this.min = age.valueMin();
        this.max = age.valueMax();
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        if(i != null){
        return i >= min && i <= max;
        }

        return false;
    }
}
