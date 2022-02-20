package com.studentrest.entities.student;

import com.studentrest.entities.subjectGrade.SubjectGrade;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentJpaRepository;

    public StudentServiceImpl(StudentRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public void addStudent(Student student) {
        studentJpaRepository.save(student);
    }

    @Override
    public void remove(Student student) {
        studentJpaRepository.delete(student);
    }

    @Override
    public Map<String, Float> getGrades(Long studentId) {

        Optional<Student> student = studentJpaRepository.findById(studentId);
        if (!student.isPresent()) return null;

        return studentJpaRepository.findById(studentId)
                .get().getGrades()
                .stream()
                .collect(Collectors.toMap(SubjectGrade::getSubjectName, SubjectGrade::getGrade));
    }
}
