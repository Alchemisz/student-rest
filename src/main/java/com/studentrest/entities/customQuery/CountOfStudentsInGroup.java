package com.studentrest.entities.customQuery;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CountOfStudentsInGroup {
    private String groupName;
    private Long countOfStudents;
}
