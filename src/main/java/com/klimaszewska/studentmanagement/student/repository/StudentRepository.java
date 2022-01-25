package com.klimaszewska.studentmanagement.student.repository;

import com.klimaszewska.studentmanagement.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student getStudentByPesel(String pesel);
    public List<Student> getStudentsBySurname(String surname);
}
