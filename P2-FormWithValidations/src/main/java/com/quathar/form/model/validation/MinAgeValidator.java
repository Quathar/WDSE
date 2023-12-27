package com.quathar.form.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {

    // <<-OVERRIDE->>
//    @Override
//    public void initialize(MinAge constraintAnnotation) {
//    }

    @Override
    public boolean isValid(LocalDate birthdate, ConstraintValidatorContext constraintValidatorContext) {
        if (birthdate == null)
            return true;

        try {
            birthdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return Period.between(
                        birthdate,
                        LocalDate.now()
                   ).getYears() >= 18;
        } catch (DateTimeParseException | IllegalArgumentException e) {
            return false;
        }
    }

}
