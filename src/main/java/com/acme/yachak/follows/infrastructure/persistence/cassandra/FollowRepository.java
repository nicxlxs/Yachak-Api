package com.acme.yachak.follows.infrastructure.persistence.cassandra;

import com.acme.yachak.follows.domain.model.aggregates.Follow;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface FollowRepository extends CassandraRepository<Follow, UUID> {
    // Métodos personalizados si son necesarios
}
