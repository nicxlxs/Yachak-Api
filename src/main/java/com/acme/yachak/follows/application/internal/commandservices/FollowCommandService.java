package com.acme.yachak.follows.application.internal.commandservices;

import com.acme.yachak.follows.domain.model.aggregates.Follow;
import com.acme.yachak.follows.infrastructure.persistence.cassandra.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class FollowCommandService {

    private final FollowRepository followRepository;

    @Autowired
    public FollowCommandService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public void deleteFollow(UUID followingUserId) {
        if (!followRepository.existsById(followingUserId)) {
            throw new RuntimeException("Follow not found with ID: " + followingUserId);
        }
        followRepository.deleteById(followingUserId);
    }

    public Follow updateFollow(UUID followingUserId, Follow followDetails) {
        Follow follow = followRepository.findById(followingUserId)
                .orElseThrow(() -> new RuntimeException("Follow not found with ID: " + followingUserId));

        // Actualizar campos
        follow.setFollowedUserId(followDetails.getFollowedUserId());
        follow.setCreatedAt(followDetails.getCreatedAt());

        return followRepository.save(follow);
    }
}

