package com.studentrest.entities;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Student {

    private final String firstName;
    private final String lastName;
    private final Integer age;
    private Map<String, Grade> grades;

    public void addGrade(String subject, Grade grade){
        if (grades == null)
            grades = new HashMap<>();
        grades.put(subject, grade);
    }
}
