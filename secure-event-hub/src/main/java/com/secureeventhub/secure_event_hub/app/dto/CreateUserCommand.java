package com.secureeventhub.secure_event_hub.app.dto;

import com.secureeventhub.secure_event_hub.domain.authentication.user.UserRole;

public record CreateUserCommand(String email, String password, UserRole role) { }
