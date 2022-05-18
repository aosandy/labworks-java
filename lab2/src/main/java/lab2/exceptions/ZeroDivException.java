package lab2.exceptions;

public class ZeroDivException extends ArithmeticException {
    private final String message;

    public ZeroDivException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
