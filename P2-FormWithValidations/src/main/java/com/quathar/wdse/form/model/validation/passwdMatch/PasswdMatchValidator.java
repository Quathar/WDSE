package com.quathar.wdse.form.model.validation.passwdMatch;

import com.quathar.wdse.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <h1>Password Match Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class PasswdMatchValidator implements ConstraintValidator<PasswdMatch, Params> {

    // <<-METHODS->>
    @Override
    public void initialize(PasswdMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Params params, ConstraintValidatorContext constraintValidatorContext) {
        // We use this one because it is null-safe
        return java.util.Objects.equals(params.getPasswd(), params.getConfirmPasswd());
//        return params.getPasswd() != null && params.getPasswd().equals(params.getConfirmPasswd());
    }

}
