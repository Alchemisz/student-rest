package com.studentrest.entities.student;

import com.studentrest.entities.Grade;

import java.util.Map;

public interface StudentRepository {

    void add(Student student);
    void remove(Student student);
    Map<String, Grade> findGradesById(Long studentId);

}
