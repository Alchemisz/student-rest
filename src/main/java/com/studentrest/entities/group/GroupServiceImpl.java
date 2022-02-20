package com.studentrest.entities.group;

import com.studentrest.entities.customQuery.CountOfStudentsInGroup;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupJpaRepository;

    public GroupServiceImpl(GroupRepository groupJpaRepository) {
        this.groupJpaRepository = groupJpaRepository;
    }

    @Override
    public StudentsGroup addGroup(StudentsGroup studentsGroup) {
        return groupJpaRepository.save(studentsGroup);
    }

    @Override
    public void removeGroup(StudentsGroup studentsGroup) {
        groupJpaRepository.delete(studentsGroup);
    }

    @Override
    public Optional<StudentsGroup> getGroup(String groupName) {
        return groupJpaRepository.findById(groupName);
    }

    @Override
    public List<StudentsGroup> getGroups() {
        return groupJpaRepository.findAll();
    }

    @Override
    public Optional<StudentsGroup> findGroupByName(String name) {
        return groupJpaRepository.findByName(name);
    }

    @Override
    public List<String> findGroupByNameLike(String pattern) {
        return groupJpaRepository.findByNameLike(pattern);
    }

    @Override
    public List<CountOfStudentsInGroup> countStudentsInGroups() {
        List<Object[]> objects = groupJpaRepository.countStudentsInGroups();
        List<CountOfStudentsInGroup> numberOfStudentsInGroups = new ArrayList<>();
        for (Object[] objs : objects)
            numberOfStudentsInGroups.add(
                    new CountOfStudentsInGroup(
                            (String) objs[0],
                            Long.valueOf(String.valueOf((BigInteger) objs[1]))));
        return numberOfStudentsInGroups;
    }
}
