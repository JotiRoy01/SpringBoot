package _7BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CardService /*implements InitializingBean implements DisposableBean*/ {

    Map<Integer, String> mp;

    public CardService(){
        mp = new HashMap<>();
        System.out.println("CardService Constructor Called");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Hii, I am Initializer before any method called but after created beans");
//        mp.put(1, "Joti");
//        mp.put(2, "Gautam");
//    }


    @PostConstruct
    public  void postConstructor(){
        System.out.println("Initiate using @postConstructor");
        mp.put(1, "Joti");
        mp.put(2, "Gautam");
    }
    public void addToCard(){
        System.out.println("Added to cart");
    }
    public String getValue(int key){
        return mp.get(key);
    }

    @PreDestroy
    public void stop(){
        mp.clear();
        System.out.println("Bean is getting destroyed");
}

    }


//    public void start(){
//        System.out.println("Bean is ready using init");
//        mp.put(1, "Joti");
//        mp.put(2, "Gautam");
//    }
//    public void stop(){
//        System.out.println("bean is getting Destroyed by ");
//    }

//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is getting destroyed");
//    }
//}
