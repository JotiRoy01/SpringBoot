package _7BeanLifeCycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements BeanNameAware {
    public UserService(){
        System.out.println("UserService Contructor");
    }

    @Override // Callback method -> spring call this method
    public void setBeanName(String name){
        System.out.println("Bean name is " + name);
    }
}
