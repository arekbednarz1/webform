package pl.arekbednarz.webform.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import pl.arekbednarz.webform.validators.constraint.NotNumericString;

import java.util.regex.Pattern;

public class StringWithNumberValidator implements
        ConstraintValidator<NotNumericString, String> {

    @Override
    public void initialize(NotNumericString notNumericString) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField == null || !Pattern.compile(".*\\d.*")
                .matcher(contactField)
                .matches();
    }

}
