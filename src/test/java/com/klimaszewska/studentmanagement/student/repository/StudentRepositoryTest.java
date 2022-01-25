package com.klimaszewska.studentmanagement.student.repository;

import com.klimaszewska.studentmanagement.student.Student;
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
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void saveSampleStudentsInStudentRepository(){
        Student testStudent = Student.builder().firstName("Jan").surname("Nowak").pesel("97041719721").build();
        Student testStudent2 = Student.builder().firstName("Anna").surname("Nowak").pesel("96021261816").build();
        Student testStudent3 = Student.builder().firstName("Anna").surname("Kowalska").pesel("92041727956").build();
        studentRepository.save(testStudent);
        studentRepository.save(testStudent2);
        studentRepository.save(testStudent3);
    }


    @Test
    public void whenGetStudentByPesel_thenReturnStudentWithThisPesel() {
        Student testStudent = Student.builder().firstName("Test Name").surname("Test Surname").pesel("81070145758").build();
        studentRepository.save(testStudent);
        studentRepository.flush();

        Student foundStudent = studentRepository.getStudentByPesel(testStudent.getPesel());

        assertTrue(foundStudent.getPesel().equalsIgnoreCase(testStudent.getPesel()));
    }

    @Test
    public void whenGetStudentsBySurname_thenReturnOneOrMoreStudents() {
        Student testStudent = Student.builder().firstName("Test Name").surname("Test Surname").pesel("96110165762").build();
        studentRepository.save(testStudent);
        studentRepository.flush();

        List<Student> foundStudents = studentRepository.getStudentsBySurname(testStudent.getSurname());

        assertTrue(foundStudents.size() >= 1);
    }


    @Test
    public void whenGetStudentsBySurname_thenGetOnlyStudentsWithThisSurname() {
        String selectedSurname = "Nowak";
        List<Student> studentsBySurname = studentRepository.getStudentsBySurname(selectedSurname);

        for (Student student : studentsBySurname) {
            assertTrue(selectedSurname.equalsIgnoreCase(student.getSurname()));
        }
    }
}