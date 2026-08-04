package com.secureeventhub.secure_event_hub.domain.shared;

import com.secureeventhub.secure_event_hub.domain.exception.InvalidPasswordException;

public record Password(String value) {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 100;
    public static Password of(String value) {
        return new Password(value);
    }

    public Password {
        validate(value);
    }

    private static void validate(String value) {
        if(value == null) throw new InvalidPasswordException("Password cannot be null.");
        if(value.isBlank()) throw new InvalidPasswordException("Password cannot be blank.");
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new InvalidPasswordException(
                    "Password must have between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters."
            );
        }
    }
}
