package lab4;

public class MyClass {
    @MyAnnotation
    private void firstMethod() {
        System.out.println("First method invoked");
    }

    @MyAnnotation(3)
    private void secondMethod() {
        System.out.println("Second method invoked");
    }

    @MyAnnotation(value = 10)
    private void thirdMethod() {
        System.out.println("Third method invoked");
    }

    private void fourthMethod() {
        System.out.println("Fourth method invoked");
    }
}
