package pl.arekbednarz.webform.validators.constraint;


import pl.arekbednarz.webform.validators.StringWithNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringWithNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNumericString {
    String message() default "Value cannot contain any number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
