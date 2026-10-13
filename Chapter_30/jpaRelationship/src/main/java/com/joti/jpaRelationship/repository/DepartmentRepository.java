package com.joti.jpaRelationship.repository;

import com.joti.jpaRelationship.model.Department;
import com.joti.jpaRelationship.service.DepartmentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Department department){
        entityManager.persist(department);
    }

    @Transactional
    public Department getDepartmentById(Long id){
        return entityManager.find(Department.class, id);
    }
}
