package com.joti.aopPointCutProxies.aspect;


import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(com.joti.aopPointCutProxies.controller..*)")
    public void controllerLayer(){
        //empty body
    }

    @Pointcut("within(com.joti.aopPointCutProxies.service..*)")
    public void serviceLayer(){
        //empty body
    }

    @Pointcut("within(com.joti.aopPointCutProxies.controller..*)")
    public void dtoLayer(){
        //empty body
    }

    @Pointcut("within(com.joti.aopPointCutProxies.controller..*)")
    public void repositroyLayer(){
        //empty body
    }

    @Pointcut("execution(public * * (..)")
    public void allpackge(){

    }

    @Pointcut("serviceLayer() && allpackage()")
    public void allpackgeService(){

    }

    @Pointcut("execution(* *.get*(..)")
    public void getterMethod(){

    }

}
