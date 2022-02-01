package com.studentrest.entities.group;

import org.springframework.stereotype.Service;

import java.util.Optional;


public interface GroupService {

    void addGroup(Group group);
    void removeGroup(Group group);
    Optional<Group> getGroup(String groupName);

}
