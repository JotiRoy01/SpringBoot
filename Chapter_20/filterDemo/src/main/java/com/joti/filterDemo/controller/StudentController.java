package com.joti.filterDemo.controller;

import com.joti.filterDemo.studentDTO.StudentDTO;
import com.joti.filterDemo.service.StudentService;
import com.joti.filterDemo.studentDTO.StudentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentDTO student){

        StudentResponseDTO responseDTO =  studentService.createStudent(student);
        return ResponseEntity.ok(responseDTO);
    }
}
