package lab2.exceptions;

public class SizeOverflowException extends RuntimeException {
    private final String message;

    public SizeOverflowException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
