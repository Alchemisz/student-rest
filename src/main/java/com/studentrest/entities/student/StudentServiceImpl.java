package com.studentrest.entities.student;

import com.studentrest.entities.Grade;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
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
