package com.quathar.form.model.validation;

import com.quathar.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDataVoidValidator implements ConstraintValidator<CheckDataVoid, Params> {

    // <<-OVERRIDE->>
    @Override
    public boolean isValid(Params params, ConstraintValidatorContext constraintValidatorContext) {
        String email = params.getEmail();
        String mobilePhone = params.getMobilePhone();

        if (email == null | mobilePhone == null) return false;

        if (!email.isBlank() && mobilePhone.isBlank()) return true;
        if (email.isBlank() && !mobilePhone.isBlank()) return true;

        return !email.isBlank() && !mobilePhone.isBlank();
    }

}
