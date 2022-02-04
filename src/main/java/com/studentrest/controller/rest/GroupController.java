package com.studentrest.controller.rest;

import com.studentrest.entities.group.StudentsGroup;
import com.studentrest.entities.group.GroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@RequestBody StudentsGroup studentsGroup){
        groupService.addGroup(studentsGroup);
    }

    @ApiOperation(value = "Return list of groups", notes = "Simple note")
    @GetMapping
    public List<StudentsGroup> getGroups(){
        return groupService.getGroups();
    }

}
