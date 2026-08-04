package com.secureeventhub.secure_event_hub.domain.exception;

import com.secureeventhub.secure_event_hub.domain.DomainException;

public class UserAlreadyExistsException extends DomainException {
    public UserAlreadyExistsException() {
        super("User already exists.");
    }
}
