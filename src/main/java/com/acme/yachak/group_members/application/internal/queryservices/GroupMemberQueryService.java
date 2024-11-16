package com.acme.yachak.group_members.application.internal.queryservices;

import com.acme.yachak.group_members.domain.model.aggregates.GroupMember;
import com.acme.yachak.group_members.infrastructure.persistence.cassandra.GroupMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.Optional;

@Service
public class GroupMemberQueryService {

    private final GroupMemberRepository groupMemberRepository;

    @Autowired
    public GroupMemberQueryService(GroupMemberRepository groupMemberRepository) {
        this.groupMemberRepository = groupMemberRepository;
    }

    public Optional<GroupMember> getGroupMemberById(UUID groupId, UUID userId) {
        return groupMemberRepository.findById(groupId);  // Custom methods may be required for complex queries
    }

    public Iterable<GroupMember> getAllGroupMembers() {
        return groupMemberRepository.findAll();
    }
}
