package com.joti.aopPointCutProxies.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
//
//    @Before("execution(public String com.joti.aopPointCutProxies.service.StudentService.getStudent())")
//    public void loginBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }
//
//    @Before("execution(com.joti.aopPointCutProxies.dto.Student " +
//            "com.joti.aopPointCutProxies.service.StudentService.createStudent(" +
//            "com.joti.aopPointCutProxies.dto.Student))")
//    public void logBeforcreted(){
//        System.out.println("Called created Student from Aspect");
//    }

    @Before("com.joti.aopPointCutProxies.aspect.ApplicationPointcuts.allpackgeService ()")
    public void logBeforeMethod(){
        System.out.println("Method Intercepted");
    }


}
