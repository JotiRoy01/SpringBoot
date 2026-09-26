package com.joti.interceptor.intercepter;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingIntercepter implements HandlerInterceptor {
    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                              Object handler){

        System.out.println("Incoming Request -------------------");

        System.out.println("HTTP Method: " + request.getMethod());
        System.out.println("Request URI: "+ request.getRequestURI());
        System.out.println("Request Parameter: " + request.getQueryString());
        System.out.println("Client IP: " + request.getRemoteAddr());
        System.out.println("Token Header: " + request.getHeader("token"));

        if(handler instanceof HandlerMethod handlerMethod){
            System.out.println("Controller: " + handlerMethod.getBeanType().getName());
            System.out.println("Controller Method: " + handlerMethod.getMethod());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {


        System.out.println("PostHandle called");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        System.out.println("Response status: " + response.getStatus());
    }

}
