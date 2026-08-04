package com.secureeventhub.secure_event_hub.domain.exception;

import com.secureeventhub.secure_event_hub.domain.DomainException;

public class InvalidUserIdException extends DomainException {
    public InvalidUserIdException(String message) {
        super(message);
    }
}
