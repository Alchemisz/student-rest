package com.studentrest.entities.group;

import com.studentrest.entities.customQuery.CountOfStudentsInGroup;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface GroupService {

    StudentsGroup addGroup(StudentsGroup studentsGroup);
    void removeGroup(StudentsGroup studentsGroup);
    Optional<StudentsGroup> getGroup(String groupName);

    List<StudentsGroup> getGroups();

    Optional<StudentsGroup> findGroupByName(String name);

    List<String> findGroupByNameLike(String name);

    List<CountOfStudentsInGroup> countStudentsInGroups();
}
