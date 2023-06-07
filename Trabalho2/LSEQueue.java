package Trabalho2;

public class LSEQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LSEQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }

        T removedElement = front.data;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return removedElement;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        Node<T> current = front;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
