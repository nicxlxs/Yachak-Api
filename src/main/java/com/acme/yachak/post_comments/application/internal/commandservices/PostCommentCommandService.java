package com.acme.yachak.post_comments.application.internal.commandservices;

import com.acme.yachak.post_comments.domain.model.aggregates.PostComment;
import com.acme.yachak.post_comments.infrastructure.persistence.cassandra.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostCommentCommandService {

    private final PostCommentRepository postCommentRepository;

    @Autowired
    public PostCommentCommandService(PostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    public PostComment createPostComment(PostComment postComment) {
        postComment.setCommentId(UUID.randomUUID());
        return postCommentRepository.save(postComment);
    }

    public void deletePostComment(UUID commentId) {
        postCommentRepository.deleteById(commentId);
    }

    public PostComment updatePostComment(PostComment postComment) {
        return postCommentRepository.save(postComment);
    }
}
