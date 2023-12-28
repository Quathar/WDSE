package com.quathar.wdse.form.model.validation.ageMatch;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h1>Age Match Constraint</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = AgeMatchValidator.class)
@Documented
public @interface AgeMatch {

    String message() default "{form.error.age.unmatched}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
