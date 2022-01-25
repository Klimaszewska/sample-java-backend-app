package com.klimaszewska.studentmanagement.classregister.controller;

import com.klimaszewska.studentmanagement.classregister.SchoolRegisterEntry;
import com.klimaszewska.studentmanagement.classregister.service.SchoolRegisterEntryService;
import com.klimaszewska.studentmanagement.grade.Grade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class SchoolRegisterEntryController {

    private SchoolRegisterEntryService registerEntryService;

    @GetMapping(path = "/grades/entry/{entryId}")
    public SchoolRegisterEntry getRegisterEntryById(@PathVariable("entryId") Long id) {
        return registerEntryService.getRegisterEntryById(id);
    }

    @GetMapping(path = "/grades")
    public List<SchoolRegisterEntry> getAllRegisterEntries() {
        return registerEntryService.getAllRegisterEntries();
    }

    @PostMapping(path = "/grades/{studentId}")
    public SchoolRegisterEntry create(@PathVariable("studentId") Long id, @RequestBody Grade grade) {
        return registerEntryService.create(id, grade);
    }
}
