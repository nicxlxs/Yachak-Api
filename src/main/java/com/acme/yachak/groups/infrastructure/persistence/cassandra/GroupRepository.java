package com.acme.yachak.groups.infrastructure.persistence.cassandra;

import com.acme.yachak.groups.domain.model.aggregates.Group;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface GroupRepository extends CassandraRepository<Group, UUID> {
    // Métodos personalizados si son necesarios
}
