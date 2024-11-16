package com.acme.yachak.post_comments.interfaces.resources;

import com.acme.yachak.post_comments.domain.model.aggregates.PostComment;
import com.acme.yachak.post_comments.application.internal.commandservices.PostCommentCommandService;
import com.acme.yachak.post_comments.application.internal.queryservices.PostCommentQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("/api/post_comments")
@Tag(name = "Post Comments", description = "Endpoints for post comments")
public class PostCommentController {

    private final PostCommentCommandService postCommentCommandService;
    private final PostCommentQueryService postCommentQueryService;

    @Autowired
    public PostCommentController(PostCommentCommandService postCommentCommandService, PostCommentQueryService postCommentQueryService) {
        this.postCommentCommandService = postCommentCommandService;
        this.postCommentQueryService = postCommentQueryService;
    }

    @PostMapping
    public ResponseEntity<PostComment> createPostComment(@RequestBody PostComment postComment) {
        return ResponseEntity.ok(postCommentCommandService.createPostComment(postComment));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<PostComment> getPostCommentById(@PathVariable UUID commentId) {
        return postCommentQueryService.getPostCommentById(commentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<PostComment> getAllPostComments() {
        return postCommentQueryService.getAllPostComments();
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<PostComment> updatePostComment(@PathVariable UUID commentId, @RequestBody PostComment postComment) {
        Optional<PostComment> existingComment = postCommentQueryService.getPostCommentById(commentId);
        if (existingComment.isPresent()) {
            postComment.setCommentId(commentId);
            return ResponseEntity.ok(postCommentCommandService.updatePostComment(postComment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deletePostComment(@PathVariable UUID commentId) {
        postCommentCommandService.deletePostComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
