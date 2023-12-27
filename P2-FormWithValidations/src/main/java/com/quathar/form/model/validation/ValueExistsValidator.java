package com.quathar.form.model.validation;

import com.quathar.form.model.MyCollections;
import com.quathar.form.model.Params;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

public class ValueExistsValidator implements ConstraintValidator<ValueExists, String> {

    // <<-FIELD->>
    private Set<String> _keys;

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
