package com.secureeventhub.secure_event_hub.domain.authentication.user;

import com.secureeventhub.secure_event_hub.domain.shared.Email;
import com.secureeventhub.secure_event_hub.domain.shared.Password;

public class User {

    private final UserId id;
    private final Email email;
    private Password password;
    private UserRole role;
    private UserStatus status;

    private User(
            UserId id,
            Email email,
            Password password,
            UserRole role,
            UserStatus status
    ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public static User of(
            Email email,
            Password password,
            UserRole role
    ) {
        return new User(
                UserId.generate(),
                email,
                password,
                role,
                UserStatus.ACTIVE
        );
    }
}
