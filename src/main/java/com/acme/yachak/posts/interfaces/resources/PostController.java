package com.acme.yachak.posts.interfaces.resources;

import com.acme.yachak.posts.domain.model.aggregates.Post;
import com.acme.yachak.posts.application.internal.commandservices.PostCommandService;
import com.acme.yachak.posts.application.internal.queryservices.PostQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Post ", description = "Endpoints for posts")
public class PostController {

    private final PostCommandService postCommandService;
    private final PostQueryService postQueryService;

    @Autowired
    public PostController(PostCommandService postCommandService, PostQueryService postQueryService) {
        this.postCommandService = postCommandService;
        this.postQueryService = postQueryService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postCommandService.createPost(post));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable UUID postId) {
        return postQueryService.getPostById(postId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<Post> getAllPosts() {
        return postQueryService.getAllPosts();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable UUID postId, @RequestBody Post post) {
        Optional<Post> existingPost = postQueryService.getPostById(postId);
        if (existingPost.isPresent()) {
            post.setPostId(postId);
            return ResponseEntity.ok(postCommandService.updatePost(post));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID postId) {
        postCommandService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
