package com.joti.aopPointCutProxies.aspect;

import com.joti.aopPointCutProxies.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {
//
//    @Before("execution(String com.joti.aopPointCutProxies.service.StudentService.getStudent(String))")
//    public void logBeforeMethod(){
//        System.out.println("Get method Intercepted");
//    }

    @Around("@annotation(trackExecutionTime)") // binding the annotation
    public Object mesureExecutionTime(ProceedingJoinPoint joinPoint,
                                      TrackExecutionTime trackExecutionTime) throws Throwable{
            long startTime = System.currentTimeMillis();

            try {
                return joinPoint.proceed();
            }
            finally {
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;

                String operation = trackExecutionTime.operation();

                if(operation.isBlank()){
                    operation = joinPoint.getSignature().getName();
                }

                long warningThreshold = trackExecutionTime.warning();

                if(duration >= warningThreshold){
                    System.out.println("Slow operation alert: " + "Time taken by" + operation + " : "+duration);
                }
                else {
                    System.out.println(
                            "Time Taken by " + operation + " : " + duration
                    );
                }
                String methodName = joinPoint.getSignature().getName();

                System.out.println("Time taken by " + methodName + ": " +duration);
            }
    }
}
