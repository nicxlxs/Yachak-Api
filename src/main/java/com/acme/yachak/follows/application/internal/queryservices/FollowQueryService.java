package com.acme.yachak.follows.application.internal.queryservices;

import com.acme.yachak.follows.domain.model.aggregates.Follow;
import com.acme.yachak.follows.infrastructure.persistence.cassandra.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.Optional;

@Service
public class FollowQueryService {

    private final FollowRepository followRepository;

    @Autowired
    public FollowQueryService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public Optional<Follow> getFollowById(UUID followingUserId) {
        return followRepository.findById(followingUserId);
    }

    public Iterable<Follow> getAllFollows() {
        return followRepository.findAll();
    }
}
