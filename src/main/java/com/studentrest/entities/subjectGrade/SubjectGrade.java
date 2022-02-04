package com.studentrest.entities.subjectGrade;

import com.studentrest.entities.Grade;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class SubjectGrade {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String subjectName;
    private Float grade;

    public SubjectGrade(String subjectName, Grade grade) {
        this.subjectName = subjectName;
        this.grade = grade.getValue();
    }
}
