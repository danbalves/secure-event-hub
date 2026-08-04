package com.secureeventhub.secure_event_hub.infra.persistence.mapper;

import com.secureeventhub.secure_event_hub.domain.authentication.user.User;
import com.secureeventhub.secure_event_hub.domain.authentication.user.UserId;
import com.secureeventhub.secure_event_hub.domain.shared.Email;
import com.secureeventhub.secure_event_hub.domain.shared.Password;
import com.secureeventhub.secure_event_hub.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();

        entity.setId(user.id().value());
        entity.setEmail(user.email().value());
        entity.setPassword(user.password().value());
        entity.setRole(user.role());
        entity.setStatus(user.status());

        return entity;
    }

    public User toDomain(UserEntity entity) {
        return User.restore(
                UserId.of(entity.getId()),
                Email.of(entity.getEmail()),
                Password.of(entity.getPassword()),
                entity.getRole(),
                entity.getStatus()
        );
    }
}
