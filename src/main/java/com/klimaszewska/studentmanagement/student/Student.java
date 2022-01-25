package com.klimaszewska.studentmanagement.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table (name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Size(min = 2, max = 64)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2, max = 64)
    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "class_assigned")
    private String classAssigned;

    @Column(name = "address")
    @Embedded
    private StudentAddress address;

    @PESEL
    @Column(name = "pesel", nullable = false, unique = true)
    private String pesel;

    @Past
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "isDyslexic")
    private boolean isDyslexic;

/*    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SchoolRegisterEntry> classRegisterEntries;*/
}
