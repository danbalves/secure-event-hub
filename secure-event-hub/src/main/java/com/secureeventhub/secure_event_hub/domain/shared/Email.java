package com.secureeventhub.secure_event_hub.domain.shared;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Locale;

public record Email(String value) {

    public static Email of(String value) {
        return new Email(value);
    }

    public Email {
        if(value == null) throw new InvalidEmailException("E-mail cannot be null.");
        value = normalize(value);
        validate(value);
    }

    private static String normalize(String value) {
        return value
                    .trim()
                    .toLowerCase(Locale.ROOT);
    }

    private static void validate(String value) {
        if (value.isBlank()) throw new InvalidEmailException("Email cannot be blank.");
        if(!EmailValidator.getInstance().isValid(value))
            throw new InvalidEmailException("Email format is invalid.");
    }
}
