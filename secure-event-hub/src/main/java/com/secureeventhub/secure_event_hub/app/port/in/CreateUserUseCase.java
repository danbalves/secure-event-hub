package com.secureeventhub.secure_event_hub.app.port.in;

import com.secureeventhub.secure_event_hub.app.dto.CreateUserCommand;
import com.secureeventhub.secure_event_hub.app.dto.CreateUserResult;

public interface CreateUserUseCase {

    CreateUserResult execute(CreateUserCommand command);

}
