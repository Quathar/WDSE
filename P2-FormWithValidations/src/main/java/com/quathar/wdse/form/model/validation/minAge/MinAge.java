package com.quathar.wdse.form.model.validation.minAge;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h1>Min Age Constraint</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = MinAgeValidator.class)
@Documented
public @interface MinAge {

    String message() default "{form.error.birthdate.minAge}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
