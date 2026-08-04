package com.secureeventhub.secure_event_hub.domain.exception;

import com.secureeventhub.secure_event_hub.domain.DomainException;

public class InvalidEmailException extends DomainException  {
    public InvalidEmailException(String message) {
        super(message);
    }
}
