package com.acme.yachak.post_comments.application.internal.queryservices;

import com.acme.yachak.post_comments.domain.model.aggregates.PostComment;
import com.acme.yachak.post_comments.infrastructure.persistence.cassandra.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostCommentQueryService {

    private final PostCommentRepository postCommentRepository;

    @Autowired
    public PostCommentQueryService(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    public Optional<PostComment> getPostCommentById(UUID commentId) {
        return postCommentRepository.findById(commentId);
    }

    public Iterable<PostComment> getAllPostComments() {
        return postCommentRepository.findAll();
    }
}
