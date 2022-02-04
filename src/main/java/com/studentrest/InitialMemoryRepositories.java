package com.studentrest;

import com.studentrest.entities.Grade;
import com.studentrest.entities.group.StudentsGroup;
import com.studentrest.entities.group.GroupService;
import com.studentrest.entities.student.Student;
import com.studentrest.entities.student.StudentService;
import com.studentrest.entities.subjectGrade.SubjectGrade;
import org.springframework.stereotype.Component;

@Component
public class InitialMemoryRepositories {

    private final StudentService studentService;
    private final GroupService groupService;

    public InitialMemoryRepositories(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;

        StudentsGroup studentsGroup1 = new StudentsGroup("3ID13A");
        StudentsGroup studentsGroup2 = new StudentsGroup("3ID12B");
        StudentsGroup studentsGroup3 = new StudentsGroup("1ID15B");

        Student student1 = new Student("Adrian", "Rubak", 22);
        student1.addGrade(new SubjectGrade("Mobile Applications", Grade.FIVE));
        student1.addGrade(new SubjectGrade("Databases", Grade.FOUR_PLUS));

        Student student2 = new Student("Jan", "Kowalski", 21);
        student2.addGrade(new SubjectGrade("Programing in C++", Grade.THREE));
        student2.addGrade(new SubjectGrade("Programing in JAVA", Grade.THREE_PLUS));

        studentsGroup1.addStudent(student1);
        studentsGroup1.addStudent(student2);
        groupService.addGroup(studentsGroup1);
        groupService.addGroup(studentsGroup2);
        groupService.addGroup(studentsGroup3);

    }
}
