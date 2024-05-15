package pl.arekbednarz.webform.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum ApplicationStatus {
    IN_PROGRESS("In progress"),
    APPROVED("Approved");

    private final String value;
    ApplicationStatus(String value) {
        this.value = value;
    }

}
