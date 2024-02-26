package com.example.crud.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Table(name = "students")
public class Student {

    @Id
    private final Long id;
    private final String name;
    private final String email;
    private final int age;
    private final String dob;


}
