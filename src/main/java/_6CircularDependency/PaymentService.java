package _6CircularDependency;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    OrderService orderService;
    public PaymentService(OrderService orderService) {
        this.orderService = orderService;
    }
    public void pay(){
        System.out.println("Payment Done!");
        // Not its responsibility
        // orderService.getOrderDetails();
    }

}
