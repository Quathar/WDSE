package com.quathar.form.model.validation;

import com.quathar.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswdMatchValidator implements ConstraintValidator<PasswdMatch, Params> {

    // <<-OVERRIDE->>
    @Override
    public void initialize(PasswdMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Params params, ConstraintValidatorContext constraintValidatorContext) {
        // Usamos este porque es null-safe
        return Objects.equals(params.getPasswd(), params.getConfirmPasswd());
//        return params.getPasswd() != null && params.getPasswd().equals(params.getConfirmPasswd());
    }

}
