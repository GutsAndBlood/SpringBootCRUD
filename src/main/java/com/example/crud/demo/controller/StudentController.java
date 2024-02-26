package com.example.crud.demo.controller;

import com.example.crud.demo.model.Student;
import com.example.crud.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentByID(@PathVariable Long id) {
        return studentService.getStudentByID(id);
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        System.out.println(student);
        studentService.addNewStudent(student);
    }

}
