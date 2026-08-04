package com.secureeventhub.secure_event_hub.app.usecase;

import com.secureeventhub.secure_event_hub.app.dto.CreateUserCommand;
import com.secureeventhub.secure_event_hub.domain.authentication.user.User;
import com.secureeventhub.secure_event_hub.domain.authentication.user.UserRepository;
import com.secureeventhub.secure_event_hub.domain.exception.UserAlreadyExistsException;
import com.secureeventhub.secure_event_hub.domain.shared.Email;
import com.secureeventhub.secure_event_hub.domain.shared.Password;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(CreateUserCommand command) {
        Email email = Email.of(command.email());
        Password password = Password.of(command.password());

        if(userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException();
        }

        User user = User.of(email, password, command.role());
        userRepository.save(user);
    }
}
