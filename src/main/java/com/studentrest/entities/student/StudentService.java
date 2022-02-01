package com.studentrest.entities.student;


import com.studentrest.entities.Grade;

import java.util.Map;


public interface StudentService {

    void add(Student group);
    void remove(Student group);
    Map<String, Grade> getGrades(Long studentId);

}
