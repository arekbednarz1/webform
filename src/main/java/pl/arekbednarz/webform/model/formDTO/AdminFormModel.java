package pl.arekbednarz.webform.model.formDTO;


import lombok.Data;
import pl.arekbednarz.webform.validators.constraint.NotNumericString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public @Data class AdminFormModel {

    @NotNumericString
    @NotEmpty(message = "Field is mandatory")
    private String name;

    @NotNumericString
    @NotEmpty(message = "Field is mandatory")
    private String surname;

    @Size(max = 245)
    @Email(message = "Incorrect email")
    @NotEmpty(message = "Field is mandatory")
    private String email;

    @Size(min = 5, message = "Minimum 5 chars")
    private String password;

    @Size(min = 5, message = "Minimum 5 chars")
    private String passwordRepeat;



}

