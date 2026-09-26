package com.joti.interceptor.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationIntercepter implements HandlerInterceptor {

    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                              Object handler) {

        String apiKey = request.getHeader("x-api-key");

        if (apiKey != null && apiKey.equals(apiKey)){
            return false;
        }
        return true;
    }
}
