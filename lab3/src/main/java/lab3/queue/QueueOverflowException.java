package lab3.queue;

public class QueueOverflowException extends RuntimeException {
        String message;

        public QueueOverflowException(String str) {
            message = str;
        }

        public String toString() {
            return (message);
        }
}
