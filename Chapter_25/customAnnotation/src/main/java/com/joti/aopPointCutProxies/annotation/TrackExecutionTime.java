package com.joti.aopPointCutProxies.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target(ElementType.METHOD)
public @interface TrackExecutionTime {
     long warning() default  2000 ;
     String operation() default  "";

    //String warning();
}
