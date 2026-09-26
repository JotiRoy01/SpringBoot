package com.joti.filterDemo.service;

import com.joti.filterDemo.studentDTO.StudentDTO;
import com.joti.filterDemo.studentDTO.StudentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDTO createStudent(StudentDTO studentDTO){

        System.out.println("Student Created");
        StudentResponseDTO responseDTO = new StudentResponseDTO();

        responseDTO.setName(studentDTO.getName());
        responseDTO.setMessage("Student is saved successfully");

        return responseDTO ;
    }

}
