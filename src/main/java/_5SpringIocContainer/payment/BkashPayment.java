package _5SpringIocContainer.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BkashPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Payment via BKash");
    }
}
