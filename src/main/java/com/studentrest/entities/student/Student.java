package com.studentrest.entities.student;

import com.studentrest.entities.Grade;
import com.studentrest.entities.subjectGrade.SubjectGrade;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    @OneToMany(targetEntity = SubjectGrade.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<SubjectGrade> grades;

    public Student() {
    }

    public Student(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void addGrade(SubjectGrade subjectGrade){
        if (grades == null)
            grades = new LinkedList<>();
        grades.add(subjectGrade);
    }
}
