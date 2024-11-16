package com.acme.yachak.group_members.application.internal.commandservices;

import com.acme.yachak.group_members.domain.model.aggregates.GroupMember;
import com.acme.yachak.group_members.infrastructure.persistence.cassandra.GroupMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GroupMemberCommandService {

    private final GroupMemberRepository groupMemberRepository;

    @Autowired
    public GroupMemberCommandService(GroupMemberRepository groupMemberRepository) {
        this.groupMemberRepository = groupMemberRepository;
    }

    public GroupMember createGroupMember(GroupMember groupMember) {
        return groupMemberRepository.save(groupMember);
    }

    public void deleteGroupMember(UUID groupId, UUID userId) {
        // Lógica para buscar por combinación de IDs
        GroupMember groupMember = groupMemberRepository.findByGroupIdAndUserId(groupId, userId)
                .orElseThrow(() -> new RuntimeException("Group member not found with groupId: " + groupId + " and userId: " + userId));
        groupMemberRepository.delete(groupMember);
    }

    public GroupMember updateGroupMember(UUID groupId, UUID userId, GroupMember groupMemberDetails) {
        // Lógica para buscar por combinación de IDs
        GroupMember groupMember = groupMemberRepository.findByGroupIdAndUserId(groupId, userId)
                .orElseThrow(() -> new RuntimeException("Group member not found with groupId: " + groupId + " and userId: " + userId));

        // Actualizar los campos necesarios
        groupMember.setRole(groupMemberDetails.getRole());
        return groupMemberRepository.save(groupMember);
    }
}
