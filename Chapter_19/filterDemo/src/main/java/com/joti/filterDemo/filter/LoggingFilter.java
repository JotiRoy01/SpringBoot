package com.joti.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String requestUUID = UUID.randomUUID().toString();
        httpServletResponse.setHeader("X-Request-ID", requestUUID);

        // request log
        System.out.println("Incoming Resquest : " + httpServletRequest.getMethod()+
                 " " + httpServletRequest.getRequestURI());

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;
        // response
        System.out.println("Response status: " + httpServletResponse.getStatus());

        System.out.println("API Response time: "+ duration);

//        System.out.println("Request entered in logging filter");
//
//        chain.doFilter(request, response);
//        System.out.println("Request exiting in Logging Filter");
    }
}
