package com.studentrest.entities.group;

import java.util.List;
import java.util.Optional;


public interface GroupService {

    void addGroup(StudentsGroup studentsGroup);
    void removeGroup(StudentsGroup studentsGroup);
    Optional<StudentsGroup> getGroup(String groupName);

    List<StudentsGroup> getGroups();

}
