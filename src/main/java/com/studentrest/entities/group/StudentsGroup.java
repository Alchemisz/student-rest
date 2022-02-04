package com.studentrest.entities.group;

import com.studentrest.entities.student.Student;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class StudentsGroup {

    @ApiModelProperty(notes = "Name of group", name = "name", required = true)
    @Id
    private String name;

    @OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_fk", referencedColumnName = "name")
    private List<Student> students;

    public StudentsGroup() {
    }

    public StudentsGroup(String name) {
        this.name = name;
    }

    public void addStudent(Student student){
        if (students == null) {
            students = new LinkedList<>();
        }
        students.add(student);
    }

}
