package com.acme.yachak.group_members.infrastructure.persistence.cassandra;

import com.acme.yachak.group_members.domain.model.aggregates.GroupMember;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;
import java.util.UUID;

public interface GroupMemberRepository extends CassandraRepository<GroupMember, UUID> {
    Optional<GroupMember> findByGroupIdAndUserId(UUID groupId, UUID userId);
}
