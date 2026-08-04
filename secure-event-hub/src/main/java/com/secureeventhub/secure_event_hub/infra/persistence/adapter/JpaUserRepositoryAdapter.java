package com.secureeventhub.secure_event_hub.infra.persistence.adapter;

import com.secureeventhub.secure_event_hub.app.port.out.UserRepository;
import com.secureeventhub.secure_event_hub.domain.authentication.user.User;
import com.secureeventhub.secure_event_hub.domain.shared.Email;
import com.secureeventhub.secure_event_hub.infra.persistence.mapper.UserMapper;
import com.secureeventhub.secure_event_hub.infra.persistence.repository.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository repository;
    private final UserMapper mapper;

    public JpaUserRepositoryAdapter(
            JpaUserRepository repository,
            UserMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void save(User user) {
        repository.save(mapper.toEntity(user));
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return repository.findByEmail(email.value())
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return repository.existsByEmail(email.value());
    }
}
