package _5SpringIocContainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("_5SpringIocContainer")
public class AppConfig {

    @Bean
    public User createUser(){
        return new User("jot", 27);
    }

}

