package com.joti.aop.service;

import com.joti.aop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student){
        System.out.println("Student Saved");
        //throw new RuntimeException("Some error happend");
        return student;
    }

    public String dummyMethod(String s) {
        System.out.println("dummMethod is called in StudentService");
        return  s;
    }
}
