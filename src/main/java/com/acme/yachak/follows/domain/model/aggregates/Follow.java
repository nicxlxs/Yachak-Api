package com.acme.yachak.follows.domain.model.aggregates;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.time.Instant;
import java.util.UUID;

@Table("follows")
public class Follow {
    @PrimaryKey
    private UUID followingUserId;
    private UUID followedUserId;

    @CreatedDate
    private Instant createdAt;

    // Getters and Setters

    public UUID getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(UUID followingUserId) {
        this.followingUserId = followingUserId;
    }

    public UUID getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(UUID followedUserId) {
        this.followedUserId = followedUserId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
