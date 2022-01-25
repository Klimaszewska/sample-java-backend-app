package com.klimaszewska.studentmanagement.student.service;

import com.klimaszewska.studentmanagement.classregister.repository.SchoolRegisterEntryRepository;
import com.klimaszewska.studentmanagement.student.Student;
import com.klimaszewska.studentmanagement.student.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRegisterEntryRepository registerEntryRepository;

    @Before
    public void saveSampleStudentsInStudentRepository() {
        Student testStudent = Student.builder().firstName("Jan").surname("Nowak").pesel("97041719721").build();
        Student testStudent2 = Student.builder().firstName("Anna").surname("Kowalska").pesel("92041727956").build();
        studentRepository.save(testStudent);
        studentRepository.save(testStudent2);
        studentRepository.flush();
    }

    @Test
    public void whenDelete_thenGetNoStudentWithProvidedId() {
        Student student = studentRepository.getOne((long) 2);
        this.studentRepository.delete(student);
        List<Student> remainingStudents = studentRepository.findAll();

        assertFalse(remainingStudents.contains(student));
    }

}
