package _7BeanLifeCycle;

import org.springframework.stereotype.Component;

@Component
public class B {
    A  a;
    public void setB(A a){
        this.a = a;
    }
}
