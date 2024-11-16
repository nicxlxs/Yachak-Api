package com.acme.yachak.posts.application.internal.queryservices;

import com.acme.yachak.posts.domain.model.aggregates.Post;
import com.acme.yachak.posts.infrastructure.persistence.cassandra.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostQueryService {

    private final PostRepository postRepository;

    @Autowired
    public PostQueryService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> getPostById(UUID postId) {
        return postRepository.findById(postId);
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
