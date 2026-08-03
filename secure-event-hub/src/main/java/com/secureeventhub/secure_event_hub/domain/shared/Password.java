package com.secureeventhub.secure_event_hub.domain.shared;

public record Password(String value) {
    public static Password of(String value) {
        return new Password(value);
    }

    public Password {
        validate(value);
    }

    private static void validate(String value) {
        if(value == null) throw new InvalidPasswordException("Password cannot be null.");
        if(value.isBlank()) throw new InvalidPasswordException("Password cannot be blank.");
        if (value.length() < 8) throw new InvalidPasswordException("Password must have at least 8 characters.");
        if (value.length() > 100) throw new InvalidPasswordException("Password must have at most 100 characters.");
    }
}
