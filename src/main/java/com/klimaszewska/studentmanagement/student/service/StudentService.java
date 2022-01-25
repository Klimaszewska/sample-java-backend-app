package com.klimaszewska.studentmanagement.student.service;

import com.klimaszewska.studentmanagement.student.Student;
import com.klimaszewska.studentmanagement.student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public Student createStudent(@Valid @RequestBody Student student){
        return this.studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return this.studentRepository.getOne(id);
    }

    public List<Student> getStudentsBySurname(@Valid String surname){
        return this.studentRepository.getStudentsBySurname(surname);
    }

    public Student getStudentByPesel(@Valid String pesel){
        return this.studentRepository.getStudentByPesel(pesel);
    }

    public Student update(Long id, Student student) {
        Student updatedStudent = this.studentRepository.getOne(id);
        updatedStudent.setAddress(student.getAddress());
        updatedStudent.setClassAssigned(student.getClassAssigned());
        updatedStudent.setDateOfBirth(student.getDateOfBirth());
        updatedStudent.setDyslexic(student.isDyslexic());
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setSurname(student.getSurname());
        updatedStudent.setPesel(student.getPesel());
        return this.studentRepository.save(updatedStudent);
    }

    public void delete(Long id, Student student){
        Student persistedStudent = this.studentRepository.getOne(id);
        this.studentRepository.delete(persistedStudent);

    }
}
