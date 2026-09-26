package com.joti.aop.service;

public class LoggingServiceUtil {
    public static void logStart(String className, String methodName){
        System.out.println("Class Name: "+ className);
        System.out.println("Method Name: "+methodName);
    }
    public static void logEnd(String className, String methodName){
        System.out.println("Class Name: "+ className);
        System.out.println("Method Name: "+methodName);
    }
}
