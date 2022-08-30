package com.guru.AtDev_Assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // Get All Students
    @GetMapping("/students")
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Add New Student
    @PostMapping("/students")
    public String addNewStudent(@RequestBody Students newStud) {
        return studentService.addNewStudent(newStud);
    }

    // Update Student Info
    @PutMapping("/students")
    public String updateStudent(@RequestBody Students stud) {
        return studentService.updateStudent(stud);
    }

    // Delete Student by id
    @DeleteMapping("/students/{id}")
    public String deleteStudById(@PathVariable String id) {
        return studentService.deleteStudById(id);
    }

}