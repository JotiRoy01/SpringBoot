package com.joti.aop.aspect;

import com.joti.aop.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @AfterThrowing(value = "execution(* com.joti.aop.service.StudentService.createStudent(..))",
//    throwing = "exception")
//    public void logAfterThrowingMethod(Throwable exception){
//        System.out.println("An Exception Occured");
//        System.out.println("Exception type: " + exception.getClass().getName());
//        System.out.println("Exception message: " + exception.getMessage());
//
//    }

//    @AfterReturning(value = "execution(com.joti.aop.dto.Student com.joti.aop.service.StudentService.createStudent(" +
//            "com.joti.aop.dto.Student))",
//                    returning = "result")
//    public void logAfterReturningMethod(Student result){
//        //System.out.println("Target Method Return: " + result);
//        result.setName("Partha");
//        result.setAge(27);
//
//        System.out.println("Intercepted createdStudent()");
//    }
//    public void logBeforeMethod(){
//        System.out.println("Studefnt is going to be saved");
//    }

//    @AfterThrowing(value = "execution(* com.joti.aop.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//            System.out.println("LogAfterMethod Executed");
//
//    }

//    @Around(value = "execution(* com.joti.aop.service.StudentService.createStudent(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting: "+ joinPoint.getSignature().getName());
//        try {
//            Object result =  joinPoint.proceed();
//
//            System.out.println("Execution Successful");
//            return result;
//        }
//        catch (Exception e){
//            System.out.println("Execution Fail" + e.getMessage());
//            throw  e;
//        }
//        finally {
//            System.out.println("Execution Completed");
//        }


//        System.out.println("After Target method");
//        student.setAge(30);
//        student.setName("Gobindo");

//        @Around(value = "execution(* com.joti.aop.service.StudentService.dummyMethod(..))")
//        public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//
//            Object[] arr = joinPoint.getArgs();
//            String orginalString = (String) arr[0];
//
//            String modifiedString = orginalString.toUpperCase();
//
//            Object[] modifiedArr = {
//                    modifiedString
//            };
//
//            return joinPoint.proceed(modifiedArr);

    @Around(value = "execution(* com.joti.aop.service.StudentService.dummyMethod(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] arr = joinPoint.getArgs();
        String orginalString = (String) arr[0];

        String modifiedString = orginalString.toUpperCase();

        Object[] modifiedArr = {
                modifiedString
        };

        String returnType = (String) joinPoint.proceed(modifiedArr);

        return returnType + " String Intercepted";

    }
}
