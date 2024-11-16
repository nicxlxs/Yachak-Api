package com.acme.yachak.posts.domain.model.aggregates;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.time.Instant;
import java.util.UUID;

@Table("posts")
public class Post {
    @PrimaryKey
    private UUID postId;
    private UUID userId;
    private UUID groupId;
    private String content;
    private String media;
    private float ratingAvg;
    private int ratesUp;
    private int ratesDown;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    // Getters and Setters

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public void setRatingAvg(float ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public void setRatesUp(int ratesUp) {
        this.ratesUp = ratesUp;
    }

    public void setRatesDown(int ratesDown) {
        this.ratesDown = ratesDown;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public String getContent() {
        return content;
    }

    public String getMedia() {
        return media;
    }

    public float getRatingAvg() {
        return ratingAvg;
    }

    public int getRatesUp() {
        return ratesUp;
    }

    public int getRatesDown() {
        return ratesDown;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
