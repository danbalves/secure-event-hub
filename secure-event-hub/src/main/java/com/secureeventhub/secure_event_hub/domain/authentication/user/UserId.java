package com.secureeventhub.secure_event_hub.domain.authentication.user;

import java.util.UUID;

public record UserId(UUID value) {
    public static UserId of(UUID value) {
        return new UserId(value);
    }

    public UserId {
        if(value == null) throw new InvalidUserIdException("User ID cannot be null.");
    }
}