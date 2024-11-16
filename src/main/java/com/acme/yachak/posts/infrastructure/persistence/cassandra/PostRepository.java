package com.acme.yachak.posts.infrastructure.persistence.cassandra;

import com.acme.yachak.posts.domain.model.aggregates.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface PostRepository extends CassandraRepository<Post, UUID> {
    // Métodos personalizados si son necesarios
}
