package com.acme.yachak.groups.domain.model.aggregates;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.time.Instant;
import java.util.UUID;

@Table("groups")
public class Group {
    @PrimaryKey
    private UUID groupId;
    private String name;
    private String description;
    private UUID adminId;

    @CreatedDate
    @Getter
    private Instant createdAt;

    // Getters and Setters

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdminId(UUID adminId) {
        this.adminId = adminId;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getAdminId() {
        return adminId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
