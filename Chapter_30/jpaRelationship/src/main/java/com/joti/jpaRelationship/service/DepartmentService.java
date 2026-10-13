package com.joti.jpaRelationship.service;

import com.joti.jpaRelationship.model.Department;
import com.joti.jpaRelationship.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }
}
