package com.klimaszewska.studentmanagement.classregister.repository;

import com.klimaszewska.studentmanagement.classregister.SchoolRegisterEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRegisterEntryRepository extends JpaRepository<SchoolRegisterEntry, Long> {
}
