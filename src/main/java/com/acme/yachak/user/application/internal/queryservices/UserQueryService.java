package com.acme.yachak.user.application.internal.queryservices;

import com.acme.yachak.user.domain.model.aggregates.User;
import com.acme.yachak.user.infrastructure.persistence.cassandra.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.Optional;

@Service
public class UserQueryService {

    private final UserRepository userRepository;

    @Autowired
    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Otros métodos de consulta si es necesario
}
