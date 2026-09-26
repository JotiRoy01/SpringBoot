package com.joti.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component
//@Order(3)
public class ResponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(httpServletResponse);

        chain.doFilter(request, wrapperResponse);

        byte[] originalBodyBytes =
                wrapperResponse.getContentAsByteArray();

        String originalBody = new String(originalBodyBytes);

        String modifiedBody =
                """
                {
                    "originalResponse": %s,
                    "appName": "Student Management System"
                }        
                """.formatted(originalBody);

        wrapperResponse.getWriter().write(modifiedBody);
    }
}
