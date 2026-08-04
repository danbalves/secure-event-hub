package com.secureeventhub.secure_event_hub.domain.authentication.user;

import com.secureeventhub.secure_event_hub.domain.exception.InvalidUserIdException;

import java.util.UUID;

public record UserId(UUID value) {
    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }
    public static UserId of(UUID value) {
        return new UserId(value);
    }
    public UserId {
        if(value == null) throw new InvalidUserIdException("User ID cannot be null.");
    }
}