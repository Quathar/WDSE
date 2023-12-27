package com.quathar.form.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy=ValueExistsValidator.class)
@Documented
public @interface ValueExists {

    String message() default "{form.error.default.valueNotExists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String list();

}
