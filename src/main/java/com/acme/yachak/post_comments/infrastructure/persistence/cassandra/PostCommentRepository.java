package com.acme.yachak.post_comments.infrastructure.persistence.cassandra;

import com.acme.yachak.post_comments.domain.model.aggregates.PostComment;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface PostCommentRepository extends CassandraRepository<PostComment, UUID> {
    // Métodos personalizados si son necesarios
}
