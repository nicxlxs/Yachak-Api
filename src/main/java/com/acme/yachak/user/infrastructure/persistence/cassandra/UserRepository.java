package com.acme.yachak.user.infrastructure.persistence.cassandra;

import com.acme.yachak.user.domain.model.aggregates.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface UserRepository extends CassandraRepository<User, UUID> {
    // Puedes agregar consultas personalizadas si es necesario
}
