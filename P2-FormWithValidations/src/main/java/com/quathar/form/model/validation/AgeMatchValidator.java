package com.quathar.form.model.validation;

import com.quathar.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class AgeMatchValidator implements ConstraintValidator<AgeMatch, Params> {

    @Override
    public boolean isValid(Params params, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate birthdate = params.getBirthdate();
        String age = params.getAge();
        if (birthdate == null || age == null || age.isBlank()) return true;

        try {
            return Period.between(
                    birthdate,
                    LocalDate.now()
            ).getYears() == Integer.parseInt(age);
        } catch (NumberFormatException | DateTimeParseException e) {
            return false;
        }
    }

}
