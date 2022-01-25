package com.klimaszewska.studentmanagement.classregister;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.klimaszewska.studentmanagement.grade.Grade;
import com.klimaszewska.studentmanagement.student.Student;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "class_register")
public class SchoolRegisterEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id", nullable = false)
    private Long entryId;

    @Column(name = "grade", nullable = false)
    @Embedded
    private Grade grade;

    @ManyToOne
    @JoinTable(
            name = "Register_Student",
            joinColumns = @JoinColumn(name = "entry_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Student student;
}
