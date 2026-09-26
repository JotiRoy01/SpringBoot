package com.joti.aop.service;

import com.joti.aop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImple implements StudentService{

    public void createStudent(Student student) {
        System.out.println("Student is saved successfully");
    }
}