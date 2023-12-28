package com.quathar.wdse.form.model.validation.passwdMatch;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <h1>Password Match Constraint</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy=PasswdMatchValidator.class)
@Documented
public @interface PasswdMatch {

    String message() default "{form.error.passwd.unmatched}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
