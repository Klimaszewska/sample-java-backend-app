package com.klimaszewska.studentmanagement.grade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Grade {

    @Column (name="subject_name")
    @Enumerated(EnumType.STRING)
    private ClassType subjectName;

    @Column (name="subject_grade")
    @Enumerated(EnumType.STRING)
    private GradeType grade;

}
