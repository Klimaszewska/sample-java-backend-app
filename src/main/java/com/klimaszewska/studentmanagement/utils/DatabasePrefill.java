package com.klimaszewska.studentmanagement.utils;

import com.klimaszewska.studentmanagement.classregister.SchoolRegisterEntry;
import com.klimaszewska.studentmanagement.classregister.repository.SchoolRegisterEntryRepository;
import com.klimaszewska.studentmanagement.grade.ClassType;
import com.klimaszewska.studentmanagement.grade.Grade;
import com.klimaszewska.studentmanagement.grade.GradeType;
import com.klimaszewska.studentmanagement.student.Student;
import com.klimaszewska.studentmanagement.student.StudentAddress;
import com.klimaszewska.studentmanagement.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DatabasePrefill {

    private StudentRepository studentRepository;
    private SchoolRegisterEntryRepository entryRepository;

    @PostConstruct
    private void prefillDatabaseWithSampleData() {
        Student sampleStudent = Student.builder().firstName("Anna").surname("Kowalska").pesel("88050711884").classAssigned("1B").build();
        Student sampleStudent2 = Student.builder().firstName("Jan").surname("Nowak").pesel("95010637371").classAssigned("1A").build();
        Student sampleStudent3 = Student.builder().firstName("Jan").surname("Nowak").pesel("82091822466").classAssigned("1A").address(new StudentAddress("Wybickiego 2", "41-818", "Zabrze")).build();

        studentRepository.save(sampleStudent);
        studentRepository.save(sampleStudent2);
        studentRepository.save(sampleStudent3);

        SchoolRegisterEntry schoolRegisterEntry = SchoolRegisterEntry.builder().grade(new Grade(ClassType.ENGLISCH, GradeType.SEHR_GUT)).student(sampleStudent).build();
        SchoolRegisterEntry schoolRegisterEntry2 = SchoolRegisterEntry.builder().grade(new Grade(ClassType.MUSIK, GradeType.GUT)).student(sampleStudent).build();
        SchoolRegisterEntry schoolRegisterEntry3 = SchoolRegisterEntry.builder().grade(new Grade(ClassType.BIOLOGIE, GradeType.NICHT_AUSREICHEND)).student(sampleStudent2).build();
        entryRepository.save(schoolRegisterEntry);
        entryRepository.save(schoolRegisterEntry2);
        entryRepository.save(schoolRegisterEntry3);

    }
}
