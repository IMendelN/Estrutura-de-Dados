package Atividade14_T2;

import java.util.Scanner;
import java.util.Stack;

/**
 * Classe responsável por verificar se uma palavra é um palíndromo e realizar operações com pilhas e filas.
 */
public class PalindromeChecker {

    /**
     * Verifica se uma palavra é um palíndromo.
     *
     * @param word a palavra a ser verificada
     * @return true se a palavra for um palíndromo, false caso contrário
     */
    public static boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder reversedWord = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedWord.append(stack.pop());
        }

        printStack(stack);

        return word.equals(reversedWord.toString());
    }

    /**
     * Imprime os elementos da pilha.
     *
     * @param stack a pilha a ser impressa
     */
    public static void printStack(Stack<Character> stack) {
        System.out.println("Pilha:");
        System.out.println("-----");

        for (Character character : stack) {
            System.out.println("| " + character + " |");
            System.out.println("-----");
        }
    }

    /**
     * Método principal que realiza as operações de verificação de palíndromo, uso de pilhas e filas, e operações em um HashMap.
     *
     * @param args os argumentos de linha de comando (não são utilizados)
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Insire a palavra: ");
            String word = sc.nextLine();
            boolean isPalindrome = isPalindrome(word);

            if (isPalindrome) {
                System.out.println(word + " é um palíndromo.");
            } else {
                System.out.println(word + " não é um palíndromo.");
            }
        }

        // Criação e uso da pilha
        Stack<String> studentsStack = new Stack<>();
        studentsStack.push("Marcos");
        studentsStack.push("João");
        studentsStack.push("Maria");

        System.out.println("Tamanho da pilha de alunos: " + studentsStack.size());
        System.out.println("Pilha de alunos vazia? " + studentsStack.isEmpty());
        System.out.println("Elemento no topo da pilha de alunos: " + studentsStack.peek());

        // Utilizando a pilha para inverter a ordem dos alunos em uma fila representada
        // por uma Lista Simplesmente Encadeada (LSE)
        LSEQueue<String> studentsQueue = new LSEQueue<>();
        studentsQueue.enqueue("Iago");
        studentsQueue.enqueue("Gabriela");
        studentsQueue.enqueue("Ana");

        System.out.println("Fila original:");
        studentsQueue.printQueue();

        System.out.println("Fila invertida usando a pilha:");
        while (!studentsQueue.isEmpty()) {
            studentsStack.push(studentsQueue.dequeue());
        }

        while (!studentsStack.isEmpty()) {
            studentsQueue.enqueue(studentsStack.pop());
        }

        studentsQueue.printQueue();

        // Criando e usando o HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("chave1", 10);
        hashMap.put("chave2", 20);
        hashMap.put("chave3", 30);

        System.out.println("Valor associado à chave 'chave2': " + hashMap.get("chave2"));

        hashMap.remove("chave3");

        System.out.println("Mapa após a remoção da chave 'chave3':");
        hashMap.printMap();

        if (hashMap.shouldResize()) {
            hashMap.resize();
            System.out.println("Mapa redimensionado:");
            hashMap.printMap();
        }
    }
}
