package com.studentrest.entities.student;


import com.studentrest.entities.Grade;
import com.studentrest.entities.subjectGrade.SubjectGrade;

import java.util.Map;


public interface StudentService {
    void addStudent(Student group);
    void remove(Student group);
    Map<String, Float> getGrades(Long studentId);
}
