package pl.arekbednarz.webform.model.formDTO;


import lombok.Data;
import pl.arekbednarz.webform.validators.constraint.NotNumericString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public @Data class CompanyFormModel {

    @NotEmpty(message = "Company name cannot be empty")
    private String companyName;

    @NotNumericString
    @NotEmpty(message = "Street cannot be empty")
    private String street;

    @NotEmpty(message = "House nr cannot be empty")
    private String houseNumber;

    @NotEmpty(message = "Apartment number cannot be empty")
    private String apprtNumber;

    @NotNumericString
    @NotEmpty(message = "City cannot be empty")
    private String city;

    @NotEmpty(message = "Zip cannot be empty")
    @Size(min = 5,max = 5,message = "Zip code must be 5 digits")
    private String zipCode;

    @NotNumericString
    @NotEmpty(message = "Name cannot be empty")
    private String companyOwnerName;

    @NotNumericString
    @NotEmpty(message = "Surname cannot be empty")
    private String companyOwnerSurname;

    @Size(max = 245)
    @Email(message = "Incorrect email")
    private String companyOwnerEmail;


    @Size(min = 5, message = "Minimum 5 chars")
    private String password;

    private String passwordRepeat;



}

