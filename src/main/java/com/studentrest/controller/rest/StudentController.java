package com.studentrest.controller.rest;

import com.studentrest.entities.student.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    private Map<String, Float> getStudentGrades(@PathVariable("id") Long studentId){
        return studentService.getGrades(studentId);
    }

}
