package _6CircularDependency.javacircular;

public class B {
    private A a;
//    public B(A a) {
//        this.a = a;
//    }

    public B() {
        this.a = new A();
    }
}
