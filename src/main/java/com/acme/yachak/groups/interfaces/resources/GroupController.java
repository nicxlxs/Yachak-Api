package com.acme.yachak.groups.interfaces.resources;

import com.acme.yachak.groups.domain.model.aggregates.Group;
import com.acme.yachak.groups.application.internal.commandservices.GroupCommandService;
import com.acme.yachak.groups.application.internal.queryservices.GroupQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
@Tag(name = "Groups", description = "Endpoints for groups")
public class GroupController {

    private final GroupCommandService groupCommandService;
    private final GroupQueryService groupQueryService;

    @Autowired
    public GroupController(GroupCommandService groupCommandService, GroupQueryService groupQueryService) {
        this.groupCommandService = groupCommandService;
        this.groupQueryService = groupQueryService;
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return ResponseEntity.ok(groupCommandService.createGroup(group));
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<Group> getGroupById(@PathVariable UUID groupId) {
        return groupQueryService.getGroupById(groupId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<Group> getAllGroups() {
        return groupQueryService.getAllGroups();
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<Group> updateGroup(@PathVariable UUID groupId, @RequestBody Group group) {
        Optional<Group> existingGroup = groupQueryService.getGroupById(groupId);
        if (existingGroup.isPresent()) {
            group.setGroupId(groupId);
            return ResponseEntity.ok(groupCommandService.updateGroup(group));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable UUID groupId) {
        groupCommandService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }
}
