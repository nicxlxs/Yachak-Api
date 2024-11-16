package com.acme.yachak.groups.application.internal.queryservices;

import com.acme.yachak.groups.domain.model.aggregates.Group;
import com.acme.yachak.groups.infrastructure.persistence.cassandra.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.Optional;

@Service
public class GroupQueryService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupQueryService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Optional<Group> getGroupById(UUID groupId) {
        return groupRepository.findById(groupId);
    }

    public Iterable<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
