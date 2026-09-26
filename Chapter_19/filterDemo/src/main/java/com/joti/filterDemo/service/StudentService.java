package com.joti.filterDemo.service;

import com.joti.filterDemo.StudentDTO.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(StudentDTO studentDTO){

        System.out.println("Student Created");
        System.out.println(studentDTO.getEmail());
        System.out.println(studentDTO.getName());
        System.out.println(studentDTO.getId());
    }

}
