package com.studentrest.entities.group;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void addGroup(Group group) {
        groupRepository.add(group);
    }

    @Override
    public void removeGroup(Group group) {
        groupRepository.remove(group);
    }

    @Override
    public Optional<Group> getGroup(String groupName) {
        return groupRepository.findByGroupName(groupName);
    }

    @Override
    public List<Group> getGroups() {
        return groupRepository.getAll();
    }
}
