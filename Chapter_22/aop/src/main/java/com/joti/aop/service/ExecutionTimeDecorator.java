package com.joti.aop.service;

import com.joti.aop.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeDecorator implements StudentService{
    private LoggingDecorator loggingDecorator;

    public ExecutionTimeDecorator(LoggingDecorator loggingDecorator){
        this.loggingDecorator = loggingDecorator;
    }
    @Override
    public void createStudent(Student student) {
        long start = System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        long end = System.currentTimeMillis();

        System.out.println("Execution time -------> " + (end - start));
    }
}
