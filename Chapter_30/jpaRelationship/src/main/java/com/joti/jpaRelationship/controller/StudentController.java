package com.joti.jpaRelationship.controller;

import com.joti.jpaRelationship.model.Student;
import com.joti.jpaRelationship.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @PathVariable Long deptId){
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("Done");
    }
}
