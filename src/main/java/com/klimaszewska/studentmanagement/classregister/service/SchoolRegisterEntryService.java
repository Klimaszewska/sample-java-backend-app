package com.klimaszewska.studentmanagement.classregister.service;

import com.klimaszewska.studentmanagement.classregister.SchoolRegisterEntry;
import com.klimaszewska.studentmanagement.classregister.repository.SchoolRegisterEntryRepository;
import com.klimaszewska.studentmanagement.grade.Grade;
import com.klimaszewska.studentmanagement.student.Student;
import com.klimaszewska.studentmanagement.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolRegisterEntryService {

    private SchoolRegisterEntryRepository registerEntryRepository;

    private StudentService studentService;

    public List<SchoolRegisterEntry> getAllRegisterEntries() {
        return this.registerEntryRepository.findAll();
    }

    public SchoolRegisterEntry getRegisterEntryById(Long id) {
        return this.registerEntryRepository.getOne(id);
    }

    public SchoolRegisterEntry create(Long id, Grade grade){
        //long id - studentservice
        Student studentFound = studentService.getStudentById(id);
        SchoolRegisterEntry entry = SchoolRegisterEntry.builder().grade(grade).student(studentFound).build();
        return this.registerEntryRepository.save(entry);
/*        SchoolRegisterEntry entry1 = SchoolRegisterEntry.builder().grade(grade).student(student).build();
        return this.registerEntryRepository.save(entry1);*/
    }
}
