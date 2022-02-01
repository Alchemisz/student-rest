package com.studentrest.entities.group;

import com.studentrest.entities.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class Group {

    private final String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student){
        if (students == null) {
            students = new LinkedList<Student>();
        }
        students.add(student);
    }

}
