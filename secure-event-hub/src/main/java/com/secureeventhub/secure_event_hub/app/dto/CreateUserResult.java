package com.secureeventhub.secure_event_hub.app.dto;

import java.util.UUID;

public record CreateUserResult(
    UUID id,
    String email
) {
}
