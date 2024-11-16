package com.acme.yachak.posts.application.internal.commandservices;

import com.acme.yachak.posts.domain.model.aggregates.Post;
import com.acme.yachak.posts.infrastructure.persistence.cassandra.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostCommandService {

    private final PostRepository postRepository;

    @Autowired
    public PostCommandService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        post.setPostId(UUID.randomUUID());
        return postRepository.save(post);
    }

    public void deletePost(UUID postId) {
        postRepository.deleteById(postId);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }
}
