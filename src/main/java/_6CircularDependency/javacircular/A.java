package _6CircularDependency.javacircular;

public class A {
//    private B b;
//    public A(B b) {
//        this.b = b;
//    }
    private B b;
    public A() {
        this.b = new B();
    }
}
