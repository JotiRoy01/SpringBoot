package com.joti.jpaRelationship.service;

import com.joti.jpaRelationship.model.Department;
import com.joti.jpaRelationship.model.Student;
import com.joti.jpaRelationship.repository.DepartmentRepository;
import com.joti.jpaRelationship.repository.StudentRepository;
import jakarta.persistence.Lob;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    public void createStudent(Student student, Long deptId) {
        Department department = departmentRepository.getDepartmentById(deptId);

        student.setDepartment(department);
        studentRepository.save(student);
    }
}
