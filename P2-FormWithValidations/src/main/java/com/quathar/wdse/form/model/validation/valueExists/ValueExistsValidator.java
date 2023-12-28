package com.quathar.wdse.form.model.validation.valueExists;

import com.quathar.wdse.form.model.MyCollections;
import com.quathar.wdse.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <h1>Value Exist Validator</h1>
 *
 * @since 2023-12-09
 * @version 1.0
 * @author Q
 */
public class ValueExistsValidator implements ConstraintValidator<ValueExists, String> {

    // <<-FIELD->>
    private java.util.Set<String> _keys;

    // <<-OVERRIDE->>
    @Override
    public void initialize(ValueExists constraintAnnotation) {
        switch (constraintAnnotation.list()) {
            case Params.GENDERS   -> _keys = MyCollections.getListGenders().keySet();
            case Params.COUNTRIES -> _keys = MyCollections.getListCountries().keySet();
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;

        for (String key : _keys)
            if (value.equals(key))
                return true;
        return false;
    }

}
