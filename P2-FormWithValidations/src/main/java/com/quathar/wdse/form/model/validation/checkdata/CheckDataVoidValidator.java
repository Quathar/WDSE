package com.quathar.wdse.form.model.validation.checkdata;

import com.quathar.wdse.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <h1>Check Data Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class CheckDataVoidValidator implements ConstraintValidator<CheckDataVoid, Params> {

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
