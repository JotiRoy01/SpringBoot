package _6CircularDependency.BeanScope;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    public OrderService(){
        System.out.println("Order Service Created");
    }
    public void placeOrder(){
        System.out.println("Order Placed");
    }
}
