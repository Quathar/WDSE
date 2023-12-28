package com.quathar.wdse.form.model.validation.minAge;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.time.LocalDate;

/**
 * <h1>Min Age Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {

    @Override
    public boolean isValid(LocalDate birthdate, ConstraintValidatorContext constraintValidatorContext) {
        if (birthdate == null)
            return true;

        try {
            birthdate.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return java.time.Period.between(
                        birthdate,
                        LocalDate.now()
                   ).getYears() >= 18;
        } catch (java.time.format.DateTimeParseException | IllegalArgumentException e) {
            return false;
        }
    }

}
