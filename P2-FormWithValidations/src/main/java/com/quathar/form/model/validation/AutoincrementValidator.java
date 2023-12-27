package com.quathar.form.model.validation;

import com.quathar.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AutoincrementValidator implements ConstraintValidator<Autoincrement, Params> {

    @Override
    public boolean isValid(Params params, ConstraintValidatorContext constraintValidatorContext) {
        try {
            params.setIterations(String.valueOf(Integer.parseInt(params.getIterations()) + 1));
            return true;
        } catch (NumberFormatException e) {
            params.setIterations("1");
            return false;
        }
    }

}
