package com.quathar.wdse.form.model.validation.autoincrement;

import com.quathar.wdse.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <h1>Autoincrement Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
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
