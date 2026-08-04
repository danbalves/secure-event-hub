package com.secureeventhub.secure_event_hub.domain.exception;

import com.secureeventhub.secure_event_hub.domain.DomainException;

public class InvalidPasswordException extends DomainException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
