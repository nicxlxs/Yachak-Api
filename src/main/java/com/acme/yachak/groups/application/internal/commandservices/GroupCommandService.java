package com.acme.yachak.groups.application.internal.commandservices;

import com.acme.yachak.groups.domain.model.aggregates.Group;
import com.acme.yachak.groups.infrastructure.persistence.cassandra.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class GroupCommandService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupCommandService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(Group group) {
        group.setGroupId(UUID.randomUUID());
        return groupRepository.save(group);
    }

    public void deleteGroup(UUID groupId) {
        groupRepository.deleteById(groupId);
    }

    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }
}
