package com.secureeventhub.secure_event_hub.app.usecase;

import com.secureeventhub.secure_event_hub.app.dto.CreateUserCommand;
import com.secureeventhub.secure_event_hub.app.dto.CreateUserResult;
import com.secureeventhub.secure_event_hub.app.port.in.CreateUserUseCase;
import com.secureeventhub.secure_event_hub.domain.authentication.user.User;
import com.secureeventhub.secure_event_hub.app.port.out.UserRepository;
import com.secureeventhub.secure_event_hub.domain.exception.UserAlreadyExistsException;
import com.secureeventhub.secure_event_hub.domain.shared.Email;
import com.secureeventhub.secure_event_hub.domain.shared.Password;
import org.springframework.stereotype.Service;

@Service
public class CreateUserInteractor implements CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CreateUserResult execute(CreateUserCommand command) {
        Email email = Email.of(command.email());
        Password password = Password.of(command.password());

        if(userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException();
        }

        User user = User.create(email, password, command.role());
        userRepository.save(user);

        return new CreateUserResult(
                user.id().value(),
                user.email().value()
        );
    }
}
