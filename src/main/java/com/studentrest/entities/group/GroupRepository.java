package com.studentrest.entities.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<StudentsGroup, String> {

    Optional<StudentsGroup> findByName(String name);

    @Query("select name from StudentsGroup where name like ?1%")
    List<String> findByNameLike(String pattern);

    @Query(nativeQuery = true, value = "" +
            "select g.name, count(s.id) from students_group g " +
            "left join student s on g.name = s.group_id " +
            "group by g.name")
    List<Object[]> countStudentsInGroups();


}
