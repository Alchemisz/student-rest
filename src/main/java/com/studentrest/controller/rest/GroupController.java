package com.studentrest.controller.rest;

import com.studentrest.entities.group.Group;
import com.studentrest.entities.group.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }

    @GetMapping
    public List<Group> getGroups(){
        return groupService.getGroups();
    }

}
