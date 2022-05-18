package lab3.queue;

public class Queue<T> {
    private class Node {
        private final T elem;
        private Node prev;
        public Node(T elem) {
            this.elem = elem;
        }
    }

    private Node first;
    private Node rear;
    private final int maxSize;
    private int size;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
    }

    public void add(T elem) throws QueueOverflowException {
        if (size == maxSize) {
            throw new QueueOverflowException("Queue Overflow");
        }
        Node newNode = new Node(elem);
        if (rear != null) {
            rear.prev = newNode;
        } else {
            first = newNode;
        }
        rear = newNode;
        size++;
    }

    public T get() throws QueueUnderflowException {
        if (size == 0) {
            throw new QueueUnderflowException("Queue Underflow");
        }
        T temp = first.elem;
        first = first.prev;
        size--;
        return temp;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node current = this.first;
        while (current != null) {
            str.append(current.elem).append(" ");
            current = current.prev;
        }
        return str.toString();
    }
}
