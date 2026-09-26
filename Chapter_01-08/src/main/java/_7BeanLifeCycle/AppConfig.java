package _7BeanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
//    @Bean(initMethod = "start", destroyMethod = "stop") // for initialization callback
//    public CardService getCardBean(){
//        return new CardService();
//    }
}
