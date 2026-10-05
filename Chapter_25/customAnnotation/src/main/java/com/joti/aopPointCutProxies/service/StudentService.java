package com.joti.aopPointCutProxies.service;

import com.joti.aopPointCutProxies.annotation.TrackExecutionTime;
import com.joti.aopPointCutProxies.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime
    public Student createStudent(Student student){
        System.out.println("Student Saved");
        return student;
    }

    @TrackExecutionTime
    public String getStudent(String s){
        //System.out.println(s);
        System.out.println("I am getStudent method. I recieve a controller string and save it in repository successfully");
        return s;
    }
}
