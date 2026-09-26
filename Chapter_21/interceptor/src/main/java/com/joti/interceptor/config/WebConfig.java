package com.joti.interceptor.config;

import com.joti.interceptor.intercepter.AuthenticationIntercepter;
import com.joti.interceptor.intercepter.AuthorizationIntercepter;
import com.joti.interceptor.intercepter.LoggingIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoggingIntercepter loggingIntercepter;
    private final AuthenticationIntercepter authenticationIntercepter;
    private final AuthorizationIntercepter authorizationIntercepter;

    public WebConfig(LoggingIntercepter loggingIntercepter,
                     AuthenticationIntercepter authenticationIntercepter,
                     AuthorizationIntercepter authorizationIntercepter) {
        this.loggingIntercepter = loggingIntercepter;
        this.authenticationIntercepter = authenticationIntercepter;
        this.authorizationIntercepter = authorizationIntercepter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingIntercepter).order(3);

        registry.addInterceptor(authenticationIntercepter)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/public/**")
                .order(1);

        registry.addInterceptor(authorizationIntercepter)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/public/**")
                .order(2);
    }
}
