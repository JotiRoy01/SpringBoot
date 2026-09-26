package _8XMLBasedConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public void main(String[] args){
        ApplicationContext order = new ClassPathXmlApplicationContext("beans.xml");

    }
}
