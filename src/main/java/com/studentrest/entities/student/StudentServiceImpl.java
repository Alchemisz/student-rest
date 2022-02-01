package com.studentrest.entities.student;

import com.studentrest.entities.Grade;

import java.util.Map;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }

    @Override
    public void remove(Student student) {
        studentRepository.remove(student);
    }

    @Override
    public Map<String, Grade> getGrades(Long studentId) {
        return studentRepository.findGradesById(studentId);
    }
}
