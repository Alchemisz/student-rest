package com.studentrest.entities.group;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupJpaRepository groupJpaRepository;

    public GroupServiceImpl(GroupJpaRepository groupJpaRepository) {
        this.groupJpaRepository = groupJpaRepository;
    }

    @Override
    public void addGroup(StudentsGroup studentsGroup) {
        groupJpaRepository.save(studentsGroup);
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
}
