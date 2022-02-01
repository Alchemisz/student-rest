package com.studentrest.entities.student;

import com.studentrest.entities.Grade;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final List<Student> students;

    public StudentRepositoryImpl() {
        students = new LinkedList<>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void remove(Student student) {
        students.remove(student);
    }

    @Override
    public Map<String, Grade> findGradesById(Long studentId) {
        return students.stream()
                .filter(e -> e.getId().equals(studentId))
                .findFirst()
                .get()
                .getGrades();
    }
}
