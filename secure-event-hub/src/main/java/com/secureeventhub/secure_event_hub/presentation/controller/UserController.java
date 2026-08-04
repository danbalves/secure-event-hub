package com.secureeventhub.secure_event_hub.presentation.controller;

import com.secureeventhub.secure_event_hub.app.dto.CreateUserCommand;
import com.secureeventhub.secure_event_hub.app.port.in.CreateUserUseCase;
import com.secureeventhub.secure_event_hub.domain.authentication.user.UserRole;
import com.secureeventhub.secure_event_hub.presentation.dto.CreateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestBody CreateUserRequest request
    ) {
        CreateUserCommand command =
                new CreateUserCommand(
                        request.email(),
                        request.password(),
                        UserRole.USER
                );
        createUserUseCase.execute(command);
    }
}
