package _7BeanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public void main(){
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order = context1.getBean(OrderService.class);
        order.placeOrder();

        CardService cart = context1.getBean(CardService.class);
        System.out.println(cart.getValue(1));

        context1.close();
    }
}
