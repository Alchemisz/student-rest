package com.studentrest.controller.rest;

import com.studentrest.entities.customQuery.CountOfStudentsInGroup;
import com.studentrest.entities.group.StudentsGroup;
import com.studentrest.entities.group.GroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @ApiOperation(value = "Adding a group")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentsGroup> createGroup(@RequestBody StudentsGroup studentsGroup){
        StudentsGroup created = groupService.addGroup(studentsGroup);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Return list of groups", notes = "Simple note")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentsGroup> getGroups(){
        return groupService.getGroups();
    }

    @GetMapping("/{name}")
    public ResponseEntity<StudentsGroup> findByName(@PathVariable("name") String name){
        Optional<StudentsGroup> groupByName = groupService.findGroupByName(name);
        return groupByName.map(studentsGroup -> new ResponseEntity<>(studentsGroup, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/like/{pattern}")
    public List<String> findByNameLike(@PathVariable String pattern){
        return groupService.findGroupByNameLike(pattern);
    }

    @ApiOperation("Return pairs with group name and count of students in this group")
    @GetMapping("/count")
    public ResponseEntity<List<CountOfStudentsInGroup>> countStudentsInGroups(){
        return new ResponseEntity(groupService.countStudentsInGroups(), HttpStatus.OK);
    }

}
