package lab2.exceptions;

import java.io.IOException;

public class FileNotExistException extends IOException {
    private final String message;

    public FileNotExistException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
