package com.joti.aopPointCutProxies.service;

import com.joti.aopPointCutProxies.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student){
        System.out.println("Student Saved");
        return student;
    }

    public String getStudent(){
        String s = "All Student Data";
        System.out.println(s);
        return s;
    }
}
