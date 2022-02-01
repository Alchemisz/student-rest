package com.studentrest;

import com.studentrest.entities.Grade;
import com.studentrest.entities.group.Group;
import com.studentrest.entities.group.GroupService;
import com.studentrest.entities.student.Student;
import com.studentrest.entities.student.StudentService;
import org.springframework.stereotype.Component;

@Component
public class InitialMemoryRepositories {

    private final StudentService studentService;
    private final GroupService groupService;

    public InitialMemoryRepositories(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;

        Group group1 = new Group("3ID13A");
        Group group2 = new Group("3ID12B");

        Student student1 = new Student(1L, "Adrian", "Rubak", 22);
        student1.addGrade("Mobile Applications", Grade.FIVE);
        student1.addGrade("Databases", Grade.FOUR_PLUS);
        studentService.addStudent(student1);

        Student student2 = new Student(2L, "Jan", "Kowalski", 21);
        student2.addGrade("Programing in C++", Grade.THREE);
        student2.addGrade("Programing in JAVA", Grade.THREE_PLUS);
        studentService.addStudent(student2);

        group1.addStudent(student1);
        group1.addStudent(student2);
        groupService.addGroup(group1);
        groupService.addGroup(group2);

    }
}
