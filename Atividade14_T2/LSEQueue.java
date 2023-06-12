package Atividade14_T2;

/**
 * Implementação de uma Fila utilizando uma Lista Simplesmente Encadeada (LSE).
 *
 * @param <T> o tipo de elementos armazenados na fila
 */
public class LSEQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    /**
     * Classe interna que representa um nó da lista encadeada.
     *
     * @param <T> o tipo de dados armazenados no nó
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        /**
         * Construtor da classe Node.
         *
         * @param data o dado a ser armazenado no nó
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Construtor da classe LSEQueue. Inicializa a fila vazia.
     */
    public LSEQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Adiciona um elemento ao final da fila.
     *
     * @param element o elemento a ser adicionado
     */
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

    /**
     * Remove e retorna o elemento do início da fila.
     *
     * @return o elemento removido do início da fila
     * @throws IllegalStateException se a fila estiver vazia
     */
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

    /**
     * Verifica se a fila está vazia.
     *
     * @return true se a fila estiver vazia, false caso contrário
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna o tamanho atual da fila.
     *
     * @return o tamanho da fila
     */
    public int size() {
        return size;
    }

    /**
     * Imprime os elementos da fila.
     */
    public void printQueue() {
        Node<T> current = front;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
