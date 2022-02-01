package com.studentrest.entities.group;

import java.util.Optional;

public interface GroupRepository {

    void add(Group group);
    void remove(Group group);
    Optional<Group> findByGroupName(String groupName);

}
