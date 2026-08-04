package com.secureeventhub.secure_event_hub.app.port.out;

import com.secureeventhub.secure_event_hub.domain.authentication.user.User;
import com.secureeventhub.secure_event_hub.domain.shared.Email;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findByEmail(Email email);

    boolean existsByEmail(Email email);
}
