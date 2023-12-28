package com.quathar.wdse.form.model.validation.applicationError;

import com.quathar.wdse.form.model.Icon;
import com.quathar.wdse.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.stream.Stream;

/**
 * <h1>Application Error Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class ApplicationErrorValidator implements ConstraintValidator<ApplicationError, Params> {

    // <<-FIELDS->>
    private int _counter;
    private boolean _valid;

    // <<-METHOD->>
    @Override
    public boolean isValid(Params params, ConstraintValidatorContext context) {
        _counter = 0;
        _valid = true;

        if (params.getIcon() == null) params.setIcon(new Icon());
        Stream.of(
                params.getSelectedGender(),
                params.getBirthdate(),
//                params.getDocument(),
                params.getIcon().x,
                params.getIcon().y
        ).forEach(it -> {
            if (it != null)
                _counter++;
        });

        Stream<Object> stream = Stream.of(
                params.getIterations(),
                // User data
                params.getName(),
                params.getPasswd(),
                params.getConfirmPasswd(),
                // Personal data
//                params.getSelectedGender(),
//                params.getBirthdate(),
                params.getAge(),
                params.getSelectedCountry(),
                // Contact Data
                params.getPrefix(),
                params.getMobilePhone(),
                params.getEmail(),
                params.getUrl(),
                // Other info
                params.getDocument(),
                params.getSelectedMusic(),
                params.getSelectedHobbies(),
                params.getComments(),
                // Form operation
                params.getLicense()
        );

        stream.forEach(it -> {
            if (it != null)
                _counter++;
            else _valid = false;
        });

        if (params.getIcon().x == null)
            params.setIcon(null);
        params.setCounter(_counter);
        return _valid;
    }

}
