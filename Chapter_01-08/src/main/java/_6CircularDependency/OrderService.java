package _6CircularDependency;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.pay();

        // call here
        getOrderDetails();
        System.out.println("Order Placed");
    }

    public void getOrderDetails(){
        System.out.println("Order Details");
    }
}
