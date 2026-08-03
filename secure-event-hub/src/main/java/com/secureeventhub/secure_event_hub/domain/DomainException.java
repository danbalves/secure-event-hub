package com.secureeventhub.secure_event_hub.domain;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
