package com.acme.yachak.follows.interfaces.resources;

import com.acme.yachak.follows.domain.model.aggregates.Follow;
import com.acme.yachak.follows.application.internal.commandservices.FollowCommandService;
import com.acme.yachak.follows.application.internal.queryservices.FollowQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/follows")
@Tag(name = "Follows", description = "Endpoints for follows")
public class FollowController {

    private final FollowCommandService followCommandService;
    private final FollowQueryService followQueryService;

    @Autowired
    public FollowController(FollowCommandService followCommandService, FollowQueryService followQueryService) {
        this.followCommandService = followCommandService;
        this.followQueryService = followQueryService;
    }

    @PostMapping
    public ResponseEntity<Follow> createFollow(@RequestBody Follow follow) {
        return ResponseEntity.ok(followCommandService.createFollow(follow));
    }

    @GetMapping("/{followingUserId}")
    public ResponseEntity<Follow> getFollowById(@PathVariable UUID followingUserId) {
        return followQueryService.getFollowById(followingUserId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<Follow> getAllFollows() {
        return followQueryService.getAllFollows();
    }

    @DeleteMapping("/{followingUserId}")
    public ResponseEntity<?> deleteFollow(@PathVariable UUID followingUserId) {
        try {
            followCommandService.deleteFollow(followingUserId);
            return ResponseEntity.ok("Follow deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Follow not found with ID: " + followingUserId);
        }
    }

    @PutMapping("/{followingUserId}")
    public ResponseEntity<?> updateFollow(@PathVariable UUID followingUserId, @RequestBody Follow followDetails) {
        try {
            Follow updatedFollow = followCommandService.updateFollow(followingUserId, followDetails);
            return ResponseEntity.ok(updatedFollow);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Follow not found with ID: " + followingUserId);
        }
    }
}
