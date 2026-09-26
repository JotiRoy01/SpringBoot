package _5SpringIocContainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public void main(){
        //System.out.println("helle joti");
        // tell to the spring how to create beans of each class by giving class metadata

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placedOrder();

//        Student c = new Student();
//        // Class
//        Class<Student> c1 = Student.class;

        User user = context.getBean(User.class);
        System.out.println(user.getName());
    }
}


// Reflection

/*
class name - Student
fields - name, age
Constructors -> Student()
Method -> getAttendance(), print()
Annotations
 */
//class Student{
//    private String name;
//    private int age;
//    public Student(){
//
//    }
//}