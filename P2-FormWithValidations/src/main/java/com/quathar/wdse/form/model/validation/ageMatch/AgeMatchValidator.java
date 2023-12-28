package com.quathar.wdse.form.model.validation.ageMatch;

import com.quathar.wdse.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * <h1>Age Match Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class AgeMatchValidator implements ConstraintValidator<AgeMatch, Params> {

    @Override
    public boolean isValid(Params params, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate birthdate = params.getBirthdate();
        String age = params.getAge();
        if (birthdate == null || age == null || age.isBlank()) return true;

        try {
            return java.time.Period.between(
                    birthdate,
                    LocalDate.now()
            ).getYears() == Integer.parseInt(age);
        } catch (NumberFormatException | java.time.format.DateTimeParseException e) {
            return false;
        }
    }

}
