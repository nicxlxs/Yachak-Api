package com.acme.yachak.group_members.interfaces.resources;

import com.acme.yachak.group_members.domain.model.aggregates.GroupMember;
import com.acme.yachak.group_members.application.internal.commandservices.GroupMemberCommandService;
import com.acme.yachak.group_members.application.internal.queryservices.GroupMemberQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/group_members")
@Tag(name = "Group Members", description = "Endpoints for group members")
public class GroupMemberController {

    private final GroupMemberCommandService groupMemberCommandService;
    private final GroupMemberQueryService groupMemberQueryService;

    @Autowired
    public GroupMemberController(GroupMemberCommandService groupMemberCommandService, GroupMemberQueryService groupMemberQueryService) {
        this.groupMemberCommandService = groupMemberCommandService;
        this.groupMemberQueryService = groupMemberQueryService;
    }

    @PostMapping
    public ResponseEntity<GroupMember> createGroupMember(@RequestBody GroupMember groupMember) {
        return ResponseEntity.ok(groupMemberCommandService.createGroupMember(groupMember));
    }

    @GetMapping
    public Iterable<GroupMember> getAllGroupMembers() {
        return groupMemberQueryService.getAllGroupMembers();
    }

    @GetMapping("/{groupId}/{userId}")
    public ResponseEntity<GroupMember> getGroupMemberById(@PathVariable UUID groupId, @PathVariable UUID userId) {
        Optional<GroupMember> groupMember = groupMemberQueryService.getGroupMemberById(groupId, userId);
        return groupMember
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @DeleteMapping("/{groupId}/{userId}")
    public ResponseEntity<?> deleteGroupMember(@PathVariable UUID groupId, @PathVariable UUID userId) {
        try {
            groupMemberCommandService.deleteGroupMember(groupId, userId);
            return ResponseEntity.ok("Group member deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{groupId}/{userId}")
    public ResponseEntity<?> updateGroupMember(
            @PathVariable UUID groupId, @PathVariable UUID userId,
            @RequestBody GroupMember groupMemberDetails) {
        try {
            GroupMember updatedGroupMember = groupMemberCommandService.updateGroupMember(groupId, userId, groupMemberDetails);
            return ResponseEntity.ok(updatedGroupMember);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
