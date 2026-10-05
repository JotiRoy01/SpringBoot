package com.joti.hibernate.service;

import com.joti.hibernate.model.Student;
import com.joti.hibernate.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public void createStudent(Student student) {
    }

    public Student getStudentById(Long id) {
        return null;

    }

    public void updateStudent(Student student) {
    }

    public void deleteStudent(Long id) {
    }
}
