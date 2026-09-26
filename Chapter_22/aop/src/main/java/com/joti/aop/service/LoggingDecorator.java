package com.joti.aop.service;

import com.joti.aop.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingDecorator implements StudentService{

    private StudentServiceImple studentServiceImple;

    public LoggingDecorator(StudentServiceImple studentServiceImple){
        this.studentServiceImple = studentServiceImple;
    }
    @Override
    public void createStudent(Student student) {
        System.out.println("<=============Execution Start================>");
        LoggingServiceUtil.logStart("StudentServiceImpl", "createStudent");

        studentServiceImple.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");
        System.out.println("<=============Execution End================>");
    }
}
