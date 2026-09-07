package _5SpringIocContainer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import _5SpringIocContainer.payment.PaymentService;

@Component
public class OrderService {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    
    public void placedOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
