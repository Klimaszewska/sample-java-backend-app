package com.klimaszewska.studentmanagement.student.controller;

import com.klimaszewska.studentmanagement.student.Student;
import com.klimaszewska.studentmanagement.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController {

    private StudentService studentService;

    @GetMapping(path = "/student")
    public List <Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/student/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping(path="/student")
    public Student create(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping(path="/student/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping(path = "student/{id}")
    public void delete(@PathVariable("id") Long id, @RequestBody Student student){
        studentService.delete(id, student);
    }

    @GetMapping(path = "/student/name/{surname}")
    public List<Student> getStudentsBySurname(@PathVariable("surname") String surname){
        return studentService.getStudentsBySurname(surname);
    }

    @GetMapping(path = "/student/pesel/{pesel}")
    public Student getStudentByPesel(@PathVariable("pesel") String pesel){
        return studentService.getStudentByPesel(pesel);
    }

}
