package com.studentrest.entities.group;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    private final List<Group> groups;

    public GroupRepositoryImpl() {
        groups = new LinkedList<>();
    }

    @Override
    public void add(Group group) {
        groups.add(group);
    }

    @Override
    public void remove(Group group) {
        groups.remove(group);
    }

    @Override
    public Optional<Group> findByGroupName(String groupName) {
        return groups.stream().filter(e -> e.getName().equals(groupName)).findFirst();
    }

    @Override
    public List<Group> getAll() {
        return groups;
    }
}
