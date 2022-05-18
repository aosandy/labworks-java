package lab3.queue;

public class QueueUnderflowException extends RuntimeException {
        String message;

        public QueueUnderflowException(String str) {
            message = str;
        }

        public String toString() {
            return (message);
        }
}
