package com.example.crud.demo.service;

import com.example.crud.demo.exceptions.GlobalExceptions;
import com.example.crud.demo.exceptions.StudentNotFoundException;
import com.example.crud.demo.model.Student;
import com.example.crud.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentByID (Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);

        if (studentOptional.isEmpty()) {
            throw new StudentNotFoundException("The following ID was not found: " + id);
        }

        return studentRepo.findById(id);

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new StudentNotFoundException("This Email is already in use");
        }

        Optional<Student> studentIdOptional = studentRepo.findStudentByID(student.getId());
        if(studentIdOptional.isPresent()){
            throw new StudentNotFoundException("This ID is already in use");
        }



        studentRepo.save(student);
    }


}
